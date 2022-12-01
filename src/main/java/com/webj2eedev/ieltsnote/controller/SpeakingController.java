package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.SpeakingBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.SpeakingAnswerMp3DTO;
import com.webj2eedev.ieltsnote.dto.SpeakingLogDTO;
import com.webj2eedev.ieltsnote.dto.SpeakingQADTO;
import com.webj2eedev.ieltsnote.dto.SpeakingSummaryDTO;
import com.webj2eedev.ieltsnote.entity.SpeakingCategoryDO;
import com.webj2eedev.ieltsnote.entity.SpeakingQADO;
import com.webj2eedev.ieltsnote.entity.SpeakingQAFilterDO;
import com.webj2eedev.ieltsnote.entity.SpeakingRecentWorkDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/speaking")
@Api(value = "单词管理", tags = "单词管理")
public class SpeakingController {
    @Autowired
    SpeakingBO speakingBO;
    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingCategoryDO>> queryCatetory(@RequestBody SpeakingCategoryDO pDo) {
        List<SpeakingCategoryDO> rDtos = speakingBO.queryCatetory(pDo);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSiblingCategory(@RequestBody SpeakingCategoryDO pDo) {
        Long ret = speakingBO.addSiblingCategory(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody SpeakingCategoryDO pDo) {
        Long ret = speakingBO.addChildCategory(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody SpeakingCategoryDO pDo) {
        Long ret = speakingBO.updateCategory(pDo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryQAs", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingQADTO>> queryQAs(@RequestBody SpeakingCategoryDO pDo) {
        List<SpeakingQADTO> rDtos = speakingBO.queryQAs(pDo);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/filterQAs", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingQADO>> filterQAs(@RequestBody SpeakingQAFilterDO pDo) {
        List<SpeakingQADO> rDos = speakingBO.filterQAs(pDo);
        return WrapperResponse.ok(rDos);
    }

    @ResponseBody
    @RequestMapping(value = "/addQuesion", method = {RequestMethod.POST})
    public WrapperResponse<Long> addQuesion(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.addQuesion(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateQuestion", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateQuestion(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.updateQuestion(dto);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/addAnswer", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addAnswer(@RequestParam("id") String id,
                                           @RequestParam(value = "answerThought", required = false) String answerThought,
                                           @RequestParam("answerText") String answerText,
                                           @RequestParam("embeddedResource") String embeddedResource,
                                           @RequestParam(value = "answerMp3", required = false) MultipartFile answerMp3,
                                           @RequestParam(value = "answerMp3Duration", required = false) String answerMp3Duration,
                                           @RequestParam(value = "answerComment", required = false) String answerComment,
                                           @RequestParam(value = "answerVideo", required = false) MultipartFile answerVideo,
                                           @RequestParam(value = "answerVideoPoster", required = false) MultipartFile answerVideoPoster,
                                           @RequestParam(value = "answerVideoSubtitle", required = false) MultipartFile answerVideoSubtitle,
                                           @RequestParam("creator") String creator) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
        String now = sdf.format(new Date());

        String answerMp3Ossid = null;
        if (answerMp3 != null) {
            try {
                answerMp3Ossid = "speakingTest[" + creator + "][" + now + "]["+answerMp3Duration+"].mp3";
                minioClient.putSpeakingTestMp3(answerMp3Ossid, answerMp3.getInputStream(), answerMp3.getSize(), answerMp3.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String answerVideoOssid = null;
        if (answerVideo != null) {
            try {
                answerVideoOssid = "speakingVideo[" + creator + "][" + now + "].mp4";
                minioClient.putSpeakingTestVideo(answerVideoOssid, answerVideo.getInputStream(), answerVideo.getSize(), answerVideo.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String answerVideoPosterOssid = null;
        if (answerVideoPoster != null) {
            try {
                answerVideoPosterOssid = "speakingVideo[" + creator + "][" + now + "]-poster.jpg";
                minioClient.putSpeakingTestVideo(answerVideoPosterOssid, answerVideoPoster.getInputStream(), answerVideoPoster.getSize(), answerVideoPoster.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String answerVideoSubtitleOssid = null;
        if (answerVideoSubtitle != null) {
            try {
                answerVideoSubtitleOssid = "speakingVideo[" + creator + "][" + now + "]-subtitle.srt";
                minioClient.putSpeakingTestVideo(answerVideoSubtitleOssid, answerVideoSubtitle.getInputStream(), answerVideoSubtitle.getSize(), answerVideoSubtitle.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // add answer
        SpeakingQADTO dto = SpeakingQADTO.builder()
                .questionId(Integer.parseInt(id))
                .answerThought(answerThought)
                .answerText(answerText)
                .embeddedResource(embeddedResource)
                .answerComment(answerComment)
                .answerCreator(creator).build();
        speakingBO.addAnswer(dto);

        // add mp3
        SpeakingAnswerMp3DTO mp3Dto = SpeakingAnswerMp3DTO.builder()
                .answerId(dto.getAnswerId())
                .answerMp3Ossid(answerMp3Ossid)
                .answerMp3Duration(Integer.parseInt(answerMp3Duration))
                .answerVideoOssid(answerVideoOssid)
                .answerVideoPosterOssid(answerVideoPosterOssid)
                .answerVideoSubtitleOssid(answerVideoSubtitleOssid)
                .build();
        speakingBO.addAnswerMp3(mp3Dto);
        return WrapperResponse.ok(dto.getAnswerId());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAnswer", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteAnswer(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.deleteAnswer(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerComment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerComment(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.updateAnswerComment(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerThought", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerThought(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.updateAnswerThought(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerText", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerText(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.updateAnswerText(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addAnswerMp3", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerMp3(@RequestParam("answerId") String answerId,
                                                 @RequestParam(value = "answerMp3", required = false) MultipartFile answerMp3,
                                                 @RequestParam(value = "answerMp3Duration", required = false) String answerMp3Duration,
                                                 @RequestParam("creator") String creator) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
        String now = sdf.format(new Date());
        String answerMp3Ossid = "speakingTest[" + creator + "][" + now + "]["+answerMp3Duration+"].mp3";

        try {
            minioClient.putSpeakingTestMp3(answerMp3Ossid, answerMp3.getInputStream(), answerMp3.getSize(), answerMp3.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SpeakingAnswerMp3DTO dto = SpeakingAnswerMp3DTO.builder()
                .answerId(Integer.parseInt(answerId))
                .answerMp3Ossid(answerMp3Ossid)
                .answerMp3Duration(Integer.parseInt(answerMp3Duration))
                .build();
        Long ret = speakingBO.addAnswerMp3(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAnswerMp3s", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingAnswerMp3DTO>> queryAnswerMp3s(@RequestBody SpeakingQADTO dto) {
        List<SpeakingAnswerMp3DTO> rDtos = speakingBO.queryAnswerMp3s(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/getAnswerMp3Url", method = {RequestMethod.POST})
    public WrapperResponse<String> getAnswerMp3Url(@RequestBody SpeakingAnswerMp3DTO dto) {
        String url = minioClient.getSpeakingTestMp3Url(dto.getAnswerMp3Ossid());
        return WrapperResponse.ok(url);
    }
    @ResponseBody
    @RequestMapping(value = "/getAnswerVideoUrl", method = {RequestMethod.POST})
    public WrapperResponse<String> getAnswerVideoUrl(@RequestBody SpeakingAnswerMp3DTO dto) {
        String url = minioClient.getSpeakingTestVideoUrl(dto.getAnswerVideoOssid());
        return WrapperResponse.ok(url);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerCohesionAndCoherenceTags", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerCohesionAndCoherenceTags(@RequestBody SpeakingQADTO dto) {
        Long ret = speakingBO.updateAnswerCohesionAndCoherenceTags(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody SpeakingLogDTO dto) {
        Long ret = speakingBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/querySpeakingSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingSummaryDTO>> querySpeakingSummary(@RequestBody SpeakingLogDTO dto) {
        List<SpeakingSummaryDTO> rDtos = speakingBO.querySpeakingSummary(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/queryRecentWork", method = {RequestMethod.POST})
    public WrapperResponse<List<SpeakingRecentWorkDO>> queryRecentWork() {
        List<SpeakingRecentWorkDO> rDtos = speakingBO.queryRecentWork();
        return WrapperResponse.ok(rDtos);
    }
}
