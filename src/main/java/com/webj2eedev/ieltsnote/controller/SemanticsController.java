package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.SemanticsBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.semantics.*;
import com.webj2eedev.ieltsnote.entity.semantics.SemanticsDO;
import com.webj2eedev.ieltsnote.entity.semantics.SemanticsNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/semantics")
public class SemanticsController {
    @Autowired
    SemanticsBO bo;

    @Autowired
    private MINIOClient minio;

    private final String BUCKET_NAME = "semantics";


    @ResponseBody
    @RequestMapping(value = "/addSemantics", method = {RequestMethod.POST})
    public WrapperResponse<SemanticsDO> addSemantics(@RequestBody AddSemanticsDTO pdto) {
        int uid = bo.addSemantics(pdto.getType(), pdto.getText().trim(), pdto.getCreator());

        SemanticsDO ret = bo.querySemantics(uid);

        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySemantics", method = {RequestMethod.POST})
    public WrapperResponse<SemanticsDO> querySemantics(@RequestBody QuerySemanticsDTO pdto) {
        SemanticsDO ret = bo.querySemantics(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySemanticss", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> querySemanticss(@RequestBody QuerySemanticssDTO pdto) {
        Page<SemanticsDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.querySemanticss(pdto.getCondition());

        PageInfo<SemanticsDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSemantics", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSemantics(@RequestBody DeleteSemanticsDTO pdto) {
        Long ret = bo.deleteSemantics(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateSemantics", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateSemantics(@RequestBody SemanticsDO pdo) {
        Long ret = bo.updateSemantics(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySemanticsNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<SemanticsNewlyAddedDO>> querySemanticsNewlyAdded() {
        List<SemanticsNewlyAddedDO> ret = bo.querySemanticsNewlyAdded();
        return WrapperResponse.ok(ret);
    }


    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addSemanticsExample", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSemanticsExample(@RequestBody AddSemanticsExampleDTO pdto) {
        int uid = bo.addSemanticsExample(pdto);

        return WrapperResponse.ok(uid);
    }

    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addSemanticsGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSemanticsGroup(@RequestBody AddSemanticsGroupDTO pdto) {
        int ret = bo.addSemanticsGroup(pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSemanticsInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSemanticsInGroup(@RequestBody AddSemanticsInGroupDTO pdto) {
        Integer ret = bo.addSemanticsInGroup(pdto.getGroupId(), pdto.getSemanticsType(), pdto.getSemanticsText(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSemanticsInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSemanticsInGroup(@RequestBody DeleteSemanticsInGroupDTO pdto) {
        Long ret = bo.deleteSemanticsInGroup(pdto.getGroupId(), pdto.getSemanticsId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySemanticssInGroup", method = {RequestMethod.POST})
    public WrapperResponse<List<SemanticsDO>> querySemanticssInGroup(@RequestBody QuerySemanticssInGroupDTO pdto) {
        List<SemanticsDO> ret = bo.querySemanticssInGroup(pdto.getGroupId(), pdto.getCondition());
        return WrapperResponse.ok(ret);
    }
}
