package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WordlistBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.entity.WordDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordlist")
public class WordlistController {
    @Autowired
    WordlistBO bo;

    @ResponseBody
    @RequestMapping(value = "/addWord", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addWord(@RequestBody WordDO pdo) {
        String word = pdo.getWord();
        int ret = bo.addWord(word.trim());
        return WrapperResponse.ok(ret);
    }
}
