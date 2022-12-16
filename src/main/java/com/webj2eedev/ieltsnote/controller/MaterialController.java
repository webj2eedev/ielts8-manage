package com.webj2eedev.ieltsnote.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.MaterialBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.material.DeleteMaterialDTO;
import com.webj2eedev.ieltsnote.dto.material.QueryMaterialsDTO;
import com.webj2eedev.ieltsnote.entity.material.MaterialAttachmentDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialLogDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialNewlyAddedDO;
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
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialBO bo;
    @Autowired
    MINIOClient minioClient;

    private final String MATERIAL_BUCKET_NAME = "material";

    @ResponseBody
    @RequestMapping(value = "/addMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiyMaterial(@RequestBody MaterialDO pdo) {
        int id = bo.addMaterial(pdo);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> deleteMaterial(@RequestBody DeleteMaterialDTO pdto) {
        int id = bo.deleteMaterial(pdto.getUid());
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateMaterial(@RequestBody MaterialDO pdo) {
        Long ret = bo.updateMaterial(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMaterials", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryMaterials(@RequestBody QueryMaterialsDTO pdto) {
        Page<MaterialDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryMaterials(pdto.getCondition());

        PageInfo<MaterialDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/addMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addMaterialAttachment(
            @RequestParam("materialId") String materialId,
            @RequestParam("content") String content,
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
                minioClient.putObject(MATERIAL_BUCKET_NAME, fileOssid, file.getInputStream(), file.getSize(), file.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String type = "1";

        JSONObject c =  new JSONObject();
        c.put("type", type);
        if("1".equalsIgnoreCase(type)){
            c.put("url", content);
        }else if("2".equalsIgnoreCase(type)){
            c.put("fileName", fileName);
            c.put("fileContentType", fileContentType);
            c.put("fileOssid", fileOssid);
        }else if("3".equalsIgnoreCase(type)){
            c.put("embeddedCode", content);
        }

        // add mp3
        MaterialAttachmentDO pdo = MaterialAttachmentDO.builder()
                .materialId(Integer.parseInt(materialId))
                .attachment(c.toString())
                .comment(comment)
                .creator(creator)
                .build();
        int ret = bo.addMaterialAttachment(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateMaterialAttachment(@RequestBody MaterialAttachmentDO pdo) {
        Long ret = bo.updateMaterialAttachment(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody MaterialLogDO pdo) {
        Long ret = bo.log(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/summarizeMaterialNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<MaterialNewlyAddedDO>> summarizeMaterialNewlyAdded() {
        List<MaterialNewlyAddedDO> ret = bo.summarizeMaterialNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putObject(MATERIAL_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getObjectPersistUrl(MATERIAL_BUCKET_NAME, imageId);

        return WrapperResponse.ok(url);
    }
}
