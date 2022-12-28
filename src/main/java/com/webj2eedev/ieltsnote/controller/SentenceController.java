package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.SentenceBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.sentence.*;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sentence")
public class SentenceController {
    @Autowired
    SentenceBO bo;

    @Autowired
    private MINIOClient minio;

    private final String SENTENCE_BUCKET_NAME = "sentence";


    @ResponseBody
    @RequestMapping(value = "/addSentence", method = {RequestMethod.POST})
    public WrapperResponse<SentenceDO> addSentence(@RequestBody AddSentenceDTO pdto) {
        String content = pdto.getContent().trim();
        int uid = bo.addSentence(content, pdto.getCreator());

        SentenceDO ret = bo.querySentence(uid);

        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySentence", method = {RequestMethod.POST})
    public WrapperResponse<SentenceDO> querySentence(@RequestBody QuerySentenceDTO pdto) {
        SentenceDO ret = bo.querySentence(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySentences", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> querySentences(@RequestBody QuerySentencesDTO pdto) {
        Page<SentenceDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.querySentences(pdto.getCondition());

        PageInfo<SentenceDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSentence", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSentence(@RequestBody DeleteSentenceDTO pdto) {
        Long ret = bo.deleteSentence(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(SENTENCE_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateSentence", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateSentence(@RequestBody SentenceDO pdo) {
        Long ret = bo.updateSentence(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySentenceNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<SentenceNewlyAddedDO>> querySentenceNewlyAdded() {
        List<SentenceNewlyAddedDO> ret = bo.querySentenceNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSentenceGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSentenceGroup(@RequestBody AddSentenceGroupDTO pdto) {
        int ret = bo.addSentenceGroup(pdto.getLabel().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSentenceInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSentenceInGroup(@RequestBody AddSentenceInGroupDTO pdto) {
        Integer ret = bo.addSentenceInGroup(pdto.getGroupId(), pdto.getSentence(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSentenceInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSentenceInGroup(@RequestBody DeleteSentenceInGroupDTO pdto) {
        Long ret = bo.deleteSentenceInGroup(pdto.getGroupId(), pdto.getSentenceId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySentencesInGroup", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> querySentencesInGroup(@RequestBody QuerySentencesInGroupDTO pdto) {
        Page<SentenceDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.querySentencesInGroup(pdto.getGroupId(), pdto.getCondition());

        PageInfo<SentenceDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }
}
