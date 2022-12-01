package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.StorylineBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.StorylineCategoryDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storyline")
@Api(value = "单词管理", tags = "单词管理")
public class StorylineController {
    @Autowired
    StorylineBO bo;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<StorylineCategoryDTO>> queryCatetory(@RequestBody StorylineCategoryDTO dto) {
        List<StorylineCategoryDTO> rDtos = bo.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSiblingCategory(@RequestBody StorylineCategoryDTO dto) {
        int id = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody StorylineCategoryDTO dto) {
        Long ret = bo.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCategoryById", method = {RequestMethod.POST})
    public WrapperResponse<StorylineCategoryDTO> queryCategoryById(@RequestBody StorylineCategoryDTO dto) {
        StorylineCategoryDTO rDto = bo.queryCategoryById(dto);
        return WrapperResponse.ok(rDto);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody StorylineCategoryDTO dto) {
        Long ret = bo.updateCategory(dto);
        return WrapperResponse.ok(ret);
    }
}
