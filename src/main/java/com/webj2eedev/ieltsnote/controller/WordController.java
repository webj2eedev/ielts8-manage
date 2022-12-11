package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.WordlistBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.WordNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordlistBO bo;

    @Autowired
    private MINIOClient minio;

    private final String WORD_BUCKET_NAME = "word";


    @ResponseBody
    @RequestMapping(value = "/addWord", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWord(@RequestBody WordAddDTO pdto) {
        int ret = bo.addWord(pdto.getWord().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWords", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryWords(@RequestBody WordQueryDTO pdto) {
        Page<WordDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryWords(pdto.getCondition());

        PageInfo<WordDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWord", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWord(@RequestBody WordDeleteDTO pdto) {
        Long ret = bo.deleteWord(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(WORD_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateWord", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateWord(@RequestBody WordDO pdo) {
        Long ret = bo.updateWord(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/summarizeWordNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<WordNewlyAddedDO>> summarizeWordNewlyAdded() {
        List<WordNewlyAddedDO> ret = bo.summarizeWordNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWordGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWordGroup(@RequestBody WordlistRefCreateDTO pdto) {
        int ret = bo.addWordGroup(pdto.getLabel().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWordInWordGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWordInWordGroup(@RequestBody WordlistRefWordAddDTO pdto) {
        Integer ret = bo.addWordInWordGroup(pdto.getGroupId(), pdto.getWord().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWordInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWordInGroup(@RequestBody WordlistRefWordDeleteDTO pdto) {
        Long ret = bo.deleteWordInGroup(pdto.getRefId(), pdto.getWordId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWordsInWordGroup", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryWordsInWordGroup(@RequestBody RefWordsQueryDTO pdto) {
        Page<WordDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryWordsInWordGroup(pdto.getRefId(), pdto.getCondition());

        PageInfo<WordDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }
}