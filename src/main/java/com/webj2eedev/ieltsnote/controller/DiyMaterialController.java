package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.DiyMaterialBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.entity.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/diymaterial")
public class DiyMaterialController {
    @Autowired
    DiyMaterialBO bo;
    @Autowired
    MINIOClient minioClient;

    private final String BUCKET_NAME = "diy-material-bucket";

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<DiyMaterialCategoryDO>> queryCatetory(@RequestBody DiyMaterialCategoryDO pDo) {
        List<DiyMaterialCategoryDO> rDtos = bo.queryCatetory(pDo);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody DiyMaterialCategoryDO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody DiyMaterialCategoryDO dto) {
        int id = bo.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiyMaterials", method = {RequestMethod.POST})
    public WrapperResponse<List<DiyMaterialDO>> queryDiyMaterials(@RequestBody DiyMaterialCategoryDO dto) {
        List<DiyMaterialDO> rDtos = bo.queryDiyMaterials(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addDiyMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiyMaterial(@RequestBody DiyMaterialDO dto) {
        int id = bo.addDiyMaterial(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDiyMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> deleteDiyMaterial(@RequestBody DiyMaterialDO dto) {
        int id = bo.deleteDiyMaterial(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateDiyMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateDiyMaterial(@RequestBody DiyMaterialDO pDo) {
        Long ret = bo.updateDiyMaterial(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiyMaterialAttachments", method = {RequestMethod.POST})
    public WrapperResponse<List<DiyMaterialAttachmentDO>> queryDiyMaterialAttachments(@RequestBody DiyMaterialDO dto) {
        List<DiyMaterialAttachmentDO> rDtos = bo.queryDiyMaterialAttachments(dto);
        return WrapperResponse.ok(rDtos);
    }


    @ResponseBody
    @RequestMapping(value = "/addDiyMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiyMaterialAttachment(
            @RequestParam("materialId") String materialId,
            @RequestParam("type") String type,
            @RequestParam(value = "externalUrl", required = false) String externalUrl,
            @RequestParam(value = "embeddedCode", required = false) String embeddedCode,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam("creator") String creator) {
        String fileOssid = null;
        String fileContentType = null;
        String fileName = null;
        if (file != null) {
            try {
                fileContentType = file.getContentType();
                fileName = file.getOriginalFilename();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
                String now = sdf.format(new Date());
                fileOssid = "diymaterialfile[" + creator + "][" + now + "]";
                minioClient.putObject(BUCKET_NAME, fileOssid, file.getInputStream(), file.getSize(), file.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // add mp3
        DiyMaterialAttachmentDO pDo = DiyMaterialAttachmentDO.builder()
                .materialId(Integer.parseInt(materialId))
                .type(Integer.parseInt(type))
                .externalUrl(externalUrl)
                .embeddedCode(embeddedCode)
                .fileName(fileName)
                .fileContentType(fileContentType)
                .fileOssid(fileOssid)
                .comment(comment)
                .creator(creator)
                .build();
        int ret = bo.addDiyMaterialAttachment(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateDiyMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateDiyMaterialAttachment(@RequestBody DiyMaterialAttachmentDO pDo) {
        Long ret = bo.updateDiyMaterialAttachment(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody DiyMaterialLogDO pDo) {
        Long ret = bo.log(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLogSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<DiyMaterialSummaryDO>> queryLogSummary(@RequestBody DiyMaterialLogDO dto) {
        List<DiyMaterialSummaryDO> rDtos = bo.queryLogSummary(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putObject(BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getObjectUrl(BUCKET_NAME, imageId);

        return WrapperResponse.ok(url);
    }
}
