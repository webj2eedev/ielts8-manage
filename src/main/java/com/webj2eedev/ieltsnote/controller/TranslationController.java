package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.TranslationBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translation")
@Api(value = "搭配", tags = "搭配")
public class TranslationController {
    @Autowired
    TranslationBO ccBO;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<TranslationCategoryDTO>> queryCatetory(@RequestBody TranslationCategoryDTO dto) {
        List<TranslationCategoryDTO> rDtos = ccBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody TranslationCategoryDTO dto) {
        int id = ccBO.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody TranslationCategoryDTO dto) {
        int id = ccBO.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryTranslations", method = {RequestMethod.POST})
    public WrapperResponse<List<TranslationExpressionDTO>> queryTranslations(@RequestBody TranslationCategoryDTO dto) {
        List<TranslationExpressionDTO> rDtos = ccBO.queryTranslations(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addExpression(@RequestBody TranslationExpressionDTO dto) {
        int id = ccBO.addExpression(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSample(@RequestBody TranslationExpressionDTO dto) {
        Long ret = ccBO.addSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteExpression(@RequestBody TranslationExpressionDTO dto) {
        Long ret = ccBO.deleteExpression(dto);
        return WrapperResponse.ok(ret);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody TranslationExpressionDTO dto) {
        Long ret = ccBO.deleteSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody TranslationLogDTO dto) {
        Long ret = ccBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryTranslationSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<TranslationSummaryDTO>> queryTranslationSummary(@RequestBody TranslationLogDTO dto) {
        List<TranslationSummaryDTO> rDtos = ccBO.queryTranslationSummary(dto);
        return WrapperResponse.ok(rDtos);
    }
}
