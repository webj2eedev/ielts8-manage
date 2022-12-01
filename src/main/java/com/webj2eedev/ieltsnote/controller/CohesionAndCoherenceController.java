package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.CohesionAndCoherenceBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.CohesionAndCoherenceCategoryDTO;
import com.webj2eedev.ieltsnote.dto.CohesionAndCoherenceExpressionDTO;
import com.webj2eedev.ieltsnote.dto.CCLogDTO;
import com.webj2eedev.ieltsnote.dto.CCSummaryDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cc")
@Api(value = "连贯与衔接", tags = "连贯与衔接")
public class CohesionAndCoherenceController {
    @Autowired
    CohesionAndCoherenceBO ccBO;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<CohesionAndCoherenceCategoryDTO>> queryCatetory(@RequestBody CohesionAndCoherenceCategoryDTO dto) {
        List<CohesionAndCoherenceCategoryDTO> rDtos = ccBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody CohesionAndCoherenceCategoryDTO dto) {
        int id = ccBO.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody CohesionAndCoherenceCategoryDTO dto) {
        Long ret = ccBO.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCCs", method = {RequestMethod.POST})
    public WrapperResponse<List<CohesionAndCoherenceExpressionDTO>> queryCCs(@RequestBody CohesionAndCoherenceCategoryDTO dto) {
        List<CohesionAndCoherenceExpressionDTO> rDtos = ccBO.queryCCs(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addExpression", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addExpression(@RequestBody CohesionAndCoherenceExpressionDTO dto) {
        int id = ccBO.addExpression(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSample(@RequestBody CohesionAndCoherenceExpressionDTO dto) {
        Long ret = ccBO.addSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteExpression", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteExpression(@RequestBody CohesionAndCoherenceExpressionDTO dto) {
        Long ret = ccBO.deleteExpression(dto);
        return WrapperResponse.ok(ret);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody CohesionAndCoherenceExpressionDTO dto) {
        Long ret = ccBO.deleteSample(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody CCLogDTO dto) {
        Long ret = ccBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCCSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<CCSummaryDTO>> queryCCSummary(@RequestBody CCLogDTO dto) {
        List<CCSummaryDTO> rDtos = ccBO.queryCCSummary(dto);
        return WrapperResponse.ok(rDtos);
    }
}
