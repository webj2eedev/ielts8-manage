package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.WordBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.word.*;
import com.webj2eedev.ieltsnote.entity.word.WordNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.word.WordDO;
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
    WordBO bo;

    @Autowired
    private MINIOClient minio;

    private final String WORD_BUCKET_NAME = "word";


    @ResponseBody
    @RequestMapping(value = "/addWord", method = {RequestMethod.POST})
    public WrapperResponse<WordDO> addWord(@RequestBody AddWordDTO pdto) {
        String word = pdto.getWord().trim();
        bo.addWord(word, pdto.getCreator());

        WordDO ret = bo.queryWord(word);

        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWord", method = {RequestMethod.POST})
    public WrapperResponse<WordDO> queryWord(@RequestBody QueryWordDTO pdto) {
        WordDO ret = bo.queryWord(pdto.getWord());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWords", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryWords(@RequestBody QueryWordsDTO pdto) {
        Page<WordDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryWords(pdto.getCondition());

        PageInfo<WordDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWord", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWord(@RequestBody DeleteWordDTO pdto) {
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
    @RequestMapping(value = "/queryWordNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<WordNewlyAddedDO>> queryWordNewlyAdded() {
        List<WordNewlyAddedDO> ret = bo.queryWordNewlyAdded();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWordGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWordGroup(@RequestBody AddWordGroupDTO pdto) {
        int ret = bo.addWordGroup(pdto.getLabel().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWordInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWordInGroup(@RequestBody AddWordInGroupDTO pdto) {
        Integer ret = bo.addWordInGroup(pdto.getGroupId(), pdto.getWord().trim(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWordInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWordInGroup(@RequestBody DeleteWordInGroupDTO pdto) {
        Long ret = bo.deleteWordInGroup(pdto.getGroupId(), pdto.getWordId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWordsInGroup", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryWordsInGroup(@RequestBody QueryWordsInGroupDTO pdto) {
        Page<WordDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryWordsInGroup(pdto.getGroupId(), pdto.getCondition());

        PageInfo<WordDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }
}
