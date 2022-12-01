package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.SynonymsSubstitutionBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionArticleDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionCategoryDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionLogDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionSummaryDO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/synonymssubstitution")
@Api(value = "单词管理", tags = "单词管理")
public class SynonymsSubstitutionController {
    @Autowired
    SynonymsSubstitutionBO bo;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<SynonymsSubstitutionCategoryDO>> queryCatetory(@RequestBody SynonymsSubstitutionCategoryDO dto) {
        List<SynonymsSubstitutionCategoryDO> rDtos = bo.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody SynonymsSubstitutionCategoryDO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addChildCategory(@RequestBody SynonymsSubstitutionCategoryDO dto) {
        int id = bo.addChildCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryArticles", method = {RequestMethod.POST})
    public WrapperResponse<List<SynonymsSubstitutionArticleDO>> queryArticles(@RequestBody SynonymsSubstitutionCategoryDO dto) {
        List<SynonymsSubstitutionArticleDO> rDtos = bo.queryArticles(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addArticle(@RequestBody SynonymsSubstitutionArticleDO dto) {
        int id = bo.addArticle(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateArticle", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateArticle(@RequestBody SynonymsSubstitutionArticleDO dto) {
        Long ret = bo.updateArticle(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody SynonymsSubstitutionLogDO dto) {
        Long ret = bo.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLogSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<SynonymsSubstitutionSummaryDO>> queryLogSummary(@RequestBody SynonymsSubstitutionLogDO dto) {
        List<SynonymsSubstitutionSummaryDO> rDtos = bo.queryLogSummary(dto);
        return WrapperResponse.ok(rDtos);
    }
}
