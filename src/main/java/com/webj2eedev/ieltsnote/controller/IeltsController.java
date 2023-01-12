package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.IeltsBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.entity.ielts.IeltsScoreDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ielts")
public class IeltsController {
    @Autowired
    IeltsBO bo;

    @ResponseBody
    @RequestMapping(value = "/queryScoreList", method = {RequestMethod.POST})
    public WrapperResponse<List<IeltsScoreDO>> queryScoreList() {
        List<IeltsScoreDO> ret = bo.queryScoreList();
        return WrapperResponse.ok(ret);
    }
}
