package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.BgknowledgeBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.BgknowledgeArticleDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeCategoryDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeLogDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeSummaryDTO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/bgknowledge")
@Api(value = "单词管理", tags = "单词管理")
public class BgknowledgeController {
    @Autowired
    BgknowledgeBO bo;
    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<BgknowledgeCategoryDTO>> queryCatetory(@RequestBody BgknowledgeCategoryDTO dto) {
        List<BgknowledgeCategoryDTO> rDtos = bo.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody BgknowledgeCategoryDTO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody BgknowledgeCategoryDTO dto) {
        int id = bo.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryArticles", method = {RequestMethod.POST})
    public WrapperResponse<List<BgknowledgeArticleDTO>> queryArticles(@RequestBody BgknowledgeCategoryDTO dto) {
        List<BgknowledgeArticleDTO> rDtos = bo.queryArticles(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addArticle(@RequestBody BgknowledgeArticleDTO dto) {
        int id = bo.addArticle(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateArticleContent", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateArticleContent(@RequestBody BgknowledgeArticleDTO dto) {
        Long ret = bo.updateArticleContent(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody BgknowledgeLogDTO dto) {
        Long ret = bo.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLogSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<BgknowledgeSummaryDTO>> queryLogSummary(@RequestBody BgknowledgeLogDTO dto) {
        List<BgknowledgeSummaryDTO> rDtos = bo.queryLogSummary(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putBgknowledgeObject(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getBgknowledgeObjectUrl(imageId);

        return WrapperResponse.ok(url);
    }


}
