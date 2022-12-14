package com.webj2eedev.ieltsnote.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.MaterialBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.material.*;
import com.webj2eedev.ieltsnote.entity.material.MaterialAttachmentDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/material")
public class MaterialController {
    private final String MATERIAL_BUCKET_NAME = "material";
    @Autowired
    MaterialBO bo;
    @Autowired
    MINIOClient minio;

    @ResponseBody
    @RequestMapping(value = "/addMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiyMaterial(@RequestBody MaterialDO pdo) {
        int id = bo.addMaterial(pdo);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteMaterial(@RequestBody DeleteMaterialDTO pdto) {
        Long id = bo.deleteMaterial(pdto.getUid());
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateMaterial(@RequestBody MaterialDO pdo) {
        Long ret = bo.updateMaterial(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMaterial", method = {RequestMethod.POST})
    public WrapperResponse<MaterialDO> queryMaterial(@RequestBody QueryMaterialDTO pdto) {
        MaterialDO ret = bo.queryMaterial(pdto.getUid());

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
            @RequestParam("type") String type,
            @RequestParam("content") String content,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam("creator") String creator) {
        String fileOssid = null;
        String fileContentType = null;
        String fileName = null;
        if (file != null) {
            try {
                fileName = file.getOriginalFilename();
                fileContentType = file.getContentType();
                fileOssid = "FILE_" + UUID.randomUUID();
                minio.putObject(MATERIAL_BUCKET_NAME, fileOssid, file.getInputStream(), file.getSize(), file.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        JSONObject c = new JSONObject();
        if (MaterialAttachmentDO.AttachmentType.EXTERNAL_URL.toString().equals(type)) {
            c.put("type", MaterialAttachmentDO.AttachmentType.EXTERNAL_URL);
            c.put("externalUrl", content);
        } else if (MaterialAttachmentDO.AttachmentType.FILE.toString().equals(type)) {
            c.put("type", MaterialAttachmentDO.AttachmentType.FILE);
            c.put("fileName", fileName);
            c.put("fileContentType", fileContentType);
            c.put("fileOssid", fileOssid);
        } else if (MaterialAttachmentDO.AttachmentType.SHARING_EMBED.toString().equals(type)) {
            c.put("type", MaterialAttachmentDO.AttachmentType.SHARING_EMBED);
            c.put("code", content);
        } else {
            throw new RuntimeException("type[" + type + "]????????????.");
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
    @RequestMapping(value = "/deleteMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Integer> deleteMaterialAttachment(@RequestBody DeleteMaterialAttachmentDTO pdto) {

        JSONObject attachment = JSONObject.parseObject(bo.queryMaterialAttachment(pdto.getUid()).getAttachment());
        if (MaterialAttachmentDO.AttachmentType.FILE.toString().equals(attachment.getString("type"))) {
            minio.removeObject(MATERIAL_BUCKET_NAME, attachment.getString("fileOssid"));
        }

        int id = bo.deleteMaterialAttachment(pdto.getUid());
        return WrapperResponse.ok(id);
    }


    @ResponseBody
    @RequestMapping(value = "/updateMaterialAttachment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateMaterialAttachment(@RequestBody MaterialAttachmentDO pdo) {
        Long ret = bo.updateMaterialAttachment(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMaterialAttachments", method = {RequestMethod.POST})
    public WrapperResponse<List<MaterialAttachmentDO>> queryMaterialAttachments(@RequestBody QueryMaterialAttachmentsDTO pdto) {
        List<MaterialAttachmentDO> ret = bo.queryMaterialAttachments(pdto.getMaterialId());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMaterialNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<MaterialNewlyAddedDO>> queryMaterialNewlyAdded() {
        List<MaterialNewlyAddedDO> ret = bo.queryMaterialNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public Map<String, String> uploadImage(@RequestParam(value = "upload") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minio.putObject(MATERIAL_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            Map<String, String> ret = new HashMap();
            ret.put("uploaded", "true");
            ret.put("url", "/minio/"+MATERIAL_BUCKET_NAME+"/"+imageId);
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addMaterialGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addMaterialGroup(@RequestBody AddMaterialGroupDTO pdto) {
        int ret = bo.addMaterialGroup(pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addMaterialInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addMaterialInGroup(@RequestBody AddMaterialInGroupDTO pdto) {
        Integer ret = bo.addMaterialInGroup(pdto.getGroupId(), pdto.getMaterialId(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMaterialInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteMaterialInGroup(@RequestBody DeleteMaterialInGroupDTO pdto) {
        Long ret = bo.deleteMaterialInGroup(pdto.getGroupId(), pdto.getMaterialId());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMaterialListInGroup", method = {RequestMethod.POST})
    public WrapperResponse<List<MaterialDO>> queryMaterialListInGroup(@RequestBody QueryMaterialListInGroupDTO pdto) {
        List<MaterialDO> ret = bo.queryMaterialListInGroup(pdto.getGroupId());
        return WrapperResponse.ok(ret);
    }
}
