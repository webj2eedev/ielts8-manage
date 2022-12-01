package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.CollocationBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.CollocationCategoryDTO;
import com.webj2eedev.ieltsnote.dto.CollocationExpressionDTO;
import com.webj2eedev.ieltsnote.dto.CollocationLogDTO;
import com.webj2eedev.ieltsnote.dto.CollocationSummaryDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collocation")
@Api(value = "搭配", tags = "搭配")
public class CollocationController {
    @Autowired
    CollocationBO ccBO;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<CollocationCategoryDTO>> queryCatetory(@RequestBody CollocationCategoryDTO dto) {
        List<CollocationCategoryDTO> rDtos = ccBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody CollocationCategoryDTO dto) {
        Integer ret = ccBO.addSiblingCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody CollocationCategoryDTO dto) {
        Long ret = ccBO.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCollocations", method = {RequestMethod.POST})
    public WrapperResponse<List<CollocationExpressionDTO>> queryCollocations(@RequestBody CollocationCategoryDTO dto) {
        List<CollocationExpressionDTO> rDtos = ccBO.queryCollocations(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addExpression(@RequestBody CollocationExpressionDTO dto) {
        int id = ccBO.addExpression(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSample(@RequestBody CollocationExpressionDTO dto) {
        Long ret = ccBO.addSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteExpression(@RequestBody CollocationExpressionDTO dto) {
        Long ret = ccBO.deleteExpression(dto);
        return WrapperResponse.ok(ret);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody CollocationExpressionDTO dto) {
        Long ret = ccBO.deleteSample(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody CollocationLogDTO dto) {
        Long ret = ccBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCollocationSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<CollocationSummaryDTO>> queryCollocationSummary(@RequestBody CollocationLogDTO dto) {
        List<CollocationSummaryDTO> rDtos = ccBO.queryCollocationSummary(dto);
        return WrapperResponse.ok(rDtos);
    }
}
