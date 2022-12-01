package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.GrammarBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.GrammarArticleDTO;
import com.webj2eedev.ieltsnote.dto.GrammarCategoryDTO;
import com.webj2eedev.ieltsnote.dto.GrammarLogDTO;
import com.webj2eedev.ieltsnote.dto.GrammarSummaryDTO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/grammar")
@Api(value = "单词管理", tags = "单词管理")
public class GrammarController {
    @Autowired
    GrammarBO bo;
    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarCategoryDTO>> queryCatetory(@RequestBody GrammarCategoryDTO dto) {
        List<GrammarCategoryDTO> rDtos = bo.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody GrammarCategoryDTO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody GrammarCategoryDTO dto) {
        int id = bo.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryArticles", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarArticleDTO>> queryArticles(@RequestBody GrammarCategoryDTO dto) {
        List<GrammarArticleDTO> rDtos = bo.queryArticles(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addArticle(@RequestBody GrammarArticleDTO dto) {
        int id = bo.addArticle(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateArticleContent", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateArticleContent(@RequestBody GrammarArticleDTO dto) {
        Long ret = bo.updateArticleContent(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody GrammarLogDTO dto) {
        Long ret = bo.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLogSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarSummaryDTO>> queryLogSummary(@RequestBody GrammarLogDTO dto) {
        List<GrammarSummaryDTO> rDtos = bo.queryLogSummary(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putGrammarObject(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getGrammarObjectUrl(imageId);

        return WrapperResponse.ok(url);
    }


}
