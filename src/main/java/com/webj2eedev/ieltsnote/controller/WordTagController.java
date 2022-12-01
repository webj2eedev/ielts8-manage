package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WordTagBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.WordTagDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word/tag")
@Api(value = "单词标签管理", tags = "单词标签管理")
public class WordTagController {
    @Autowired
    WordTagBO wordTagBO;

    @ResponseBody
    @RequestMapping(value = "/queryWordTags", method = {RequestMethod.POST})
    public WrapperResponse<List<WordTagDTO>> queryWordTags(@RequestBody WordTagDTO dto) {
        List<WordTagDTO> ret = wordTagBO.queryWordTags(dto);

        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/existWordTag", method = {RequestMethod.POST})
    public WrapperResponse<Boolean> existWordTag(@RequestBody WordTagDTO dto) {
        boolean ret = wordTagBO.existWordTag(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWordTag", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWordTag(@RequestBody WordTagDTO dto) {
        int id = wordTagBO.addWordTag(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWordTag", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWordTag(@RequestBody WordTagDTO dto) {
        Long ret = wordTagBO.deleteWordTag(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateWordTag", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateWordTag(@RequestBody WordTagDTO dto) {
        Long ret = wordTagBO.updateWordTag(dto);
        return WrapperResponse.ok(ret);
    }
}
