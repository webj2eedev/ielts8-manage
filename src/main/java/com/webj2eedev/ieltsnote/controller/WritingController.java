package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WritingBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.writing.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.writing.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.writing.WritingCategoryDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writing")
public class WritingController {
    @Autowired
    WritingBO bo;

    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingCategoryDO>> queryCatetory() {
        List<WritingCategoryDO> ret = bo.queryCatetory();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSiblingCategory(@RequestBody AddSiblingCategoryDTO dto) {
        Long ret = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody AddChildCategoryDTO dto) {
        Long ret = bo.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody WritingCategoryDO pdo) {
        Long ret = bo.updateCategory(pdo);
        return WrapperResponse.ok(ret);
    }

//
//    @ResponseBody
//    @RequestMapping(value = "/queryWritings", method = {RequestMethod.POST})
//    public WrapperResponse<List<WritingExpressionDO>> queryWritings(@RequestBody WritingCategoryDTO dto) {
//        List<WritingExpressionDO> ret = bo.queryWritings(dto);
//        return WrapperResponse.ok(ret);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
//    public WrapperResponse<Integer> addExpression(@RequestBody WritingExpressionDO dto) {
//        int id = bo.addExpression(dto);
//        return WrapperResponse.ok(id);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/updateExpression", method = {RequestMethod.POST})
//    public WrapperResponse<Long> updateExpression(@RequestBody WritingExpressionDO dto) {
//        Long ret = bo.updateExpression(dto);
//        return WrapperResponse.ok(ret);
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
//    public WrapperResponse<Integer> addSample(@RequestBody WritingExpressionDO dto) {
//        int id = bo.addSample(dto);
//        return WrapperResponse.ok(id);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/updateSample", method = {RequestMethod.POST})
//    public WrapperResponse<Long> updateSample(@RequestBody WritingExpressionDO dto) {
//        Long ret = bo.updateSample(dto);
//        return WrapperResponse.ok(ret);
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
//    public WrapperResponse<Long> deleteExpression(@RequestBody WritingExpressionDO dto) {
//        Long ret = bo.deleteExpression(dto);
//        return WrapperResponse.ok(ret);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
//    public WrapperResponse<Long> deleteSample(@RequestBody WritingExpressionDO dto) {
//        Long ret = bo.deleteSample(dto);
//        return WrapperResponse.ok(ret);
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "/log", method = {RequestMethod.POST})
//    public WrapperResponse<Long> log(@RequestBody WritingLogDO pDo) {
//        Long ret = bo.log(pDo);
//        return WrapperResponse.ok(ret);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/queryWritingSummary", method = {RequestMethod.POST})
//    public WrapperResponse<List<WritingSummaryDTO>> queryWritingSummary(@RequestBody WritingLogDO pDo) {
//        List<WritingSummaryDTO> rDtos = bo.queryWritingSummary(pDo);
//        return WrapperResponse.ok(rDtos);
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
//    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
//        String imageId = UUID.randomUUID().toString();
//
//        try {
//            minioClient.putWritingTestImage(imageId, image.getInputStream(), image.getSize(), image.getContentType());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        String url = minioClient.getWritingTestImageUrl(imageId);
//
//        return WrapperResponse.ok(url);
//    }
}
