package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.GrammarBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.grammar.*;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarCategoryDO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarMaterialDO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarSentenceDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @RequestMapping(value = "/queryCategory", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarCategoryDO>> queryCategory() {
        List<GrammarCategoryDO> ret = bo.queryCategory();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLeafCategory", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarCategoryDO>> queryLeafCatetory() {
        List<GrammarCategoryDO> ret = bo.queryLeafCategory();
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

    ///////////////////////////////////////////////////
    @ResponseBody
    @RequestMapping(value = "/addGrammarMaterial", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addGrammarMaterial(@RequestBody AddGrammarMaterialDTO pdto) {
        int uid = bo.addGrammarMaterial(pdto);
        return WrapperResponse.ok(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/queryGrammarMaterialList", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarMaterialDO>> queryGrammarMaterialList(@RequestBody QueryMaterialListDTO pdto) {
        if(pdto.getCategoryId() == null || "".equals(pdto.getCategoryId())){
            return WrapperResponse.ok(new ArrayList<GrammarMaterialDO>());
        }

        List<GrammarMaterialDO> ret = bo.queryGrammarMaterialList(pdto.getCategoryId());
        return WrapperResponse.ok(ret);
    }

    //////////////////////////////////////////////////////


    @ResponseBody
    @RequestMapping(value = "/addGrammarSentenceGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addGrammarSentenceGroup(@RequestBody AddGrammarSentenceGroupDTO pdto) {
        int ret = bo.addGrammarSentenceGroup(pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addGrammarSentenceInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addGrammarSentenceInGroup(@RequestBody AddGrammarSentenceInGroupDTO pdto) {
        Integer ret = bo.addGrammarSentenceInGroup(pdto.getGroupId(), pdto.getGrammarCategoryId(), pdto.getGrammarSentenceId(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGrammarSentenceInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteGrammarSentenceInGroup(@RequestBody DeleteGrammarSentenceInGroupDTO pdto) {
        Long ret = bo.deleteGrammarSentenceInGroup(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryGrammarSentenceListInGroup", method = {RequestMethod.POST})
    public WrapperResponse<List<GrammarSentenceDO>> queryGrammarSentenceListInGroup(@RequestBody QueryGrammarSentenceListInGroupDTO pdto) {
        List<GrammarSentenceDO> ret = bo.queryGrammarSentenceListInGroup(pdto.getGroupId());

        return WrapperResponse.ok(ret);
    }
}
