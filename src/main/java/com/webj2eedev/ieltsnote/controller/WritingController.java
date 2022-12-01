package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WritingBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.WritingCategoryDTO;
import com.webj2eedev.ieltsnote.dto.WritingSummaryDTO;
import com.webj2eedev.ieltsnote.entity.WritingExpressionDO;
import com.webj2eedev.ieltsnote.entity.WritingLogDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/writing")
@Api(value = "搭配", tags = "搭配")
public class WritingController {
    @Autowired
    WritingBO ccBO;

    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingCategoryDTO>> queryCatetory(@RequestBody WritingCategoryDTO dto) {
        List<WritingCategoryDTO> rDtos = ccBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSiblingCategory(@RequestBody WritingCategoryDTO dto) {
        Long ret = ccBO.addSiblingCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody WritingCategoryDTO dto) {
        Long ret = ccBO.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody WritingCategoryDTO dto) {
        Long ret = ccBO.updateCategory(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/queryWritings", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingExpressionDO>> queryWritings(@RequestBody WritingCategoryDTO dto) {
        List<WritingExpressionDO> ret = ccBO.queryWritings(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addExpression(@RequestBody WritingExpressionDO dto) {
        int id = ccBO.addExpression(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateExpression(@RequestBody WritingExpressionDO dto) {
        Long ret = ccBO.updateExpression(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSample(@RequestBody WritingExpressionDO dto) {
        int id = ccBO.addSample(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateSample(@RequestBody WritingExpressionDO dto) {
        Long ret = ccBO.updateSample(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteExpression(@RequestBody WritingExpressionDO dto) {
        Long ret = ccBO.deleteExpression(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody WritingExpressionDO dto) {
        Long ret = ccBO.deleteSample(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody WritingLogDO pDo) {
        Long ret = ccBO.log(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWritingSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingSummaryDTO>> queryWritingSummary(@RequestBody WritingLogDO pDo) {
        List<WritingSummaryDTO> rDtos = ccBO.queryWritingSummary(pDo);
        return WrapperResponse.ok(rDtos);
    }


    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putWritingTestImage(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getWritingTestImageUrl(imageId);

        return WrapperResponse.ok(url);
    }
}
