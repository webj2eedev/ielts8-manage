package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.ParaphraseBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.paraphrase.*;
import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseDO;
import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/paraphrase")
public class ParaphraseController {
    @Autowired
    ParaphraseBO bo;

    @Autowired
    private MINIOClient minio;

    private final String PARAPHRASE_BUCKET_NAME = "paraphrase";


    @ResponseBody
    @RequestMapping(value = "/addParaphrase", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addParaphrase(@RequestBody AddParaphraseDTO pdto) {
        String text = pdto.getText().trim();
        int uid = bo.addParaphrase(text, pdto.getCreator());
        return WrapperResponse.ok(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/queryParaphrases", method = {RequestMethod.POST})
    public WrapperResponse<List<ParaphraseDO>> queryParaphrases(@RequestBody QueryParaphrasesDTO pdto) {
        List<ParaphraseDO> ret = bo.queryParaphrases(pdto.getCondition());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteParaphrase", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteParaphrase(@RequestBody DeleteParaphraseDTO pdto) {
        Long ret = bo.deleteParaphrase(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(PARAPHRASE_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateParaphrase", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateParaphrase(@RequestBody ParaphraseDO pdo) {
        Long ret = bo.updateParaphrase(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryParaphraseNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<ParaphraseNewlyAddedDO>> queryParaphraseNewlyAdded() {
        List<ParaphraseNewlyAddedDO> ret = bo.queryParaphraseNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addParaphraseRewrite", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addParaphraseRewrite(@RequestBody AddParaphraseRewriteDTO pdto) {
        int uid = bo.addParaphraseRewrite(pdto);

        return WrapperResponse.ok(uid);
    }

    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addParaphraseGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addParaphraseGroup(@RequestBody AddParaphraseGroupDTO pdto) {
        int ret = bo.addParaphraseGroup(pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addParaphraseInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addParaphraseInGroup(@RequestBody AddParaphraseInGroupDTO pdto) {
        Integer ret = bo.addParaphraseInGroup(pdto.getGroupId(), pdto.getParaphrase(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteParaphraseInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteParaphraseInGroup(@RequestBody DeleteParaphraseInGroupDTO pdto) {
        Long ret = bo.deleteParaphraseInGroup(pdto.getGroupId(), pdto.getParaphraseId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryParaphrasesInGroup", method = {RequestMethod.POST})
    public WrapperResponse<List<ParaphraseDO>> queryParaphrasesInGroup(@RequestBody QueryParaphrasesInGroupDTO pdto) {
        List<ParaphraseDO> ret = bo.queryParaphrasesInGroup(pdto.getGroupId(), pdto.getCondition());
        return WrapperResponse.ok(ret);
    }
}
