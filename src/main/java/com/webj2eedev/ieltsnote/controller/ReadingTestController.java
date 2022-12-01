package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.ReadingTestBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/readingtest")
@Api(value = "单词管理", tags = "单词管理")
public class ReadingTestController {
    @Autowired
    ReadingTestBO bo;
    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<ReadingTestCategoryDTO>> queryCatetory(@RequestBody ReadingTestCategoryDTO dto) {
        List<ReadingTestCategoryDTO> rDtos = bo.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody ReadingTestCategoryDTO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody ReadingTestCategoryDTO dto) {
        int id = bo.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody ReadingTestCategoryDTO dto) {
        Long ret = bo.updateCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryArticles", method = {RequestMethod.POST})
    public WrapperResponse<List<ReadingTestArticleDTO>> queryArticles(@RequestBody ReadingTestCategoryDTO dto) {
        List<ReadingTestArticleDTO> rDtos = bo.queryArticles(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addArticle(@RequestBody ReadingTestArticleDTO dto) {
        int id = bo.addArticle(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateArticleContent", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateArticleContent(@RequestBody ReadingTestArticleDTO dto) {
        Long ret = bo.updateArticleContent(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody ReadingTestLogDTO dto) {
        Long ret = bo.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLogSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<ReadingTestSummaryDTO>> queryLogSummary(@RequestBody ReadingTestLogDTO dto) {
        List<ReadingTestSummaryDTO> rDtos = bo.queryLogSummary(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putReadingTestObject(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getReadingTestObjectUrl(imageId);

        return WrapperResponse.ok(url);
    }


}
