package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.GrammarBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarCategoryDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grammar")
public class GrammarController {
    @Autowired
    GrammarBO bo;

    @Autowired
    MINIOClient minio;

    private final String BUCKET_NAME = "grammar";


    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarCategoryDO>> queryCatetory() {
        List<GrammarCategoryDO> ret = bo.queryCatetory();
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
    public WrapperResponse<Long> updateCategory(@RequestBody GrammarCategoryDO pdo) {
        Long ret = bo.updateCategory(pdo);
        return WrapperResponse.ok(ret);
    }
}
