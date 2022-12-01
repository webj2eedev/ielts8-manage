package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.WordDictationBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.WordDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationProgressDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationProgressSummaryDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationSessionDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word/dictation")
@Api(value = "单词听写",tags = "单词听写")
public class WordDictationController {
    @Autowired
    WordDictationBO wordDictationBO;

    @ResponseBody
    @RequestMapping(value = "/createDictationSession", method = {RequestMethod.POST})
    public WrapperResponse<Integer> createDictationSession(@RequestBody WordDictationSessionDTO dto) {
        int sessionid = wordDictationBO.createDictationSession(dto);
        return WrapperResponse.ok(sessionid);
    }

    @ResponseBody
    @RequestMapping(value = "/createDictationSessionWithDictationReportDontknowWordList", method = {RequestMethod.POST})
    public WrapperResponse<Integer> createDictationSessionWithDictationReportDontknowWordList(@RequestBody WordDictationSessionDTO dto) {
        int sessionid = wordDictationBO.createDictationSessionWithDictationReportDontknowWordList(dto);
        return WrapperResponse.ok(sessionid);
    }

    @ResponseBody
    @RequestMapping(value = "/completeDictationSession", method = {RequestMethod.POST})
    public WrapperResponse<Long> completeDictationSession(@RequestBody WordDictationSessionDTO dto) {
        Long ret = wordDictationBO.completeDictationSession(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/cancelDictationSession", method = {RequestMethod.POST})
    public WrapperResponse<Long> cancelDictationSession(@RequestBody WordDictationSessionDTO dto) {
        Long ret = wordDictationBO.cancelDictationSession(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDictationSession", method = {RequestMethod.POST})
    public WrapperResponse<WordDictationSessionDTO> queryDictationSession(@RequestBody WordDictationSessionDTO dto) {
        WordDictationSessionDTO result = wordDictationBO.queryDictationSession(dto);
        return WrapperResponse.ok(result);
    }

    @ResponseBody
    @RequestMapping(value = "/addDictationSessionProgress", method = {RequestMethod.POST})
    public WrapperResponse<Long> addDictationSessionProgress(@RequestBody WordDictationProgressDTO dto) {
        Long ret = wordDictationBO.addDictationSessionProgress(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/queryDictationProgressSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<WordDictationProgressSummaryDTO>> queryDictationProgressSummary(@RequestBody WordDictationSessionDTO dto) {
        List<WordDictationProgressSummaryDTO> ret = wordDictationBO.queryDictationProgressSummary(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDictationReportDontknowWordList", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryDictationReportDontknowWordList(@RequestBody WordDictationSessionDTO dto) {
        Page<WordDTO> objects = PageHelper.startPage(dto.getPagenum(), dto.getPagesize());

        wordDictationBO.queryDictationReportDontknowWordList(dto);

        PageInfo<WordDTO> pageInfo = new PageInfo<>(objects);

        return WrapperResponse.ok(pageInfo);
    }
}