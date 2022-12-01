package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.IdiomBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.IdiomCategoryDTO;
import com.webj2eedev.ieltsnote.dto.IdiomExpressionDTO;
import com.webj2eedev.ieltsnote.dto.IdiomLogDTO;
import com.webj2eedev.ieltsnote.dto.IdiomSummaryDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idiom")
@Api(value = "搭配", tags = "搭配")
public class IdiomController {
    @Autowired
    IdiomBO ccBO;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<IdiomCategoryDTO>> queryCatetory(@RequestBody IdiomCategoryDTO dto) {
        List<IdiomCategoryDTO> rDtos = ccBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody IdiomCategoryDTO dto) {
        int id = ccBO.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody IdiomCategoryDTO dto) {
        int id = ccBO.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryIdioms", method = {RequestMethod.POST})
    public WrapperResponse<List<IdiomExpressionDTO>> queryIdioms(@RequestBody IdiomCategoryDTO dto) {
        List<IdiomExpressionDTO> rDtos = ccBO.queryIdioms(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addExpression(@RequestBody IdiomExpressionDTO dto) {
        int id = ccBO.addExpression(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSample(@RequestBody IdiomExpressionDTO dto) {
        Long ret = ccBO.addSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteExpression(@RequestBody IdiomExpressionDTO dto) {
        Long ret = ccBO.deleteExpression(dto);
        return WrapperResponse.ok(ret);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody IdiomExpressionDTO dto) {
        Long ret = ccBO.deleteSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody IdiomLogDTO dto) {
        Long ret = ccBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySummary", method = {RequestMethod.POST})
    public WrapperResponse<List<IdiomSummaryDTO>> querySummary(@RequestBody IdiomLogDTO dto) {
        List<IdiomSummaryDTO> rDtos = ccBO.querySummary(dto);
        return WrapperResponse.ok(rDtos);
    }
}
