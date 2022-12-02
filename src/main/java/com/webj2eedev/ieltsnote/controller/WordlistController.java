package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.WordlistBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.WordAddDTO;
import com.webj2eedev.ieltsnote.dto.WordQueryDTO;
import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/wordlist")
public class WordlistController {
    @Autowired
    WordlistBO bo;

    @Autowired
    private MINIOClient minio;

    private final String WORDLIST_BUCKET_NAME = "wordlist-bucket";


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
    public WrapperResponse<Long> deleteWord(@RequestBody WordAddDTO pdto) {
        Long ret = bo.deleteWord(pdto.getWord().trim());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(WORDLIST_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

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
    @RequestMapping(value = "/queryNewlyAddedWordCntSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<WordCntNewlyAddedDO>> queryNewlyAddedWordCntSummary() {
        List<WordCntNewlyAddedDO> ret = bo.queryNewlyAddedWordCntSummary();
        return WrapperResponse.ok(ret);
    }
}
