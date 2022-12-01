package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.ListeningBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/listening")
@Api(value = "单词管理", tags = "单词管理")
public class ListeningController {
    @Autowired
    ListeningBO listeningBO;
    @Autowired
    MINIOClient minioClient;

    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<ListeningCategoryDTO>> queryCatetory(@RequestBody ListeningCategoryDTO dto) {
        List<ListeningCategoryDTO> rDtos = listeningBO.queryCatetory(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSiblingCategory(@RequestBody ListeningCategoryDTO dto) {
        Long ret = listeningBO.addSiblingCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody ListeningCategoryDTO dto) {
        Long ret = listeningBO.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody ListeningCategoryDTO dto) {
        Long ret = listeningBO.updateCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryQAs", method = {RequestMethod.POST})
    public WrapperResponse<List<ListeningQADTO>> queryQAs(@RequestBody ListeningCategoryDTO dto) {
        List<ListeningQADTO> rDtos = listeningBO.queryQAs(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/addQuesion", method = {RequestMethod.POST})
    public WrapperResponse<Long> addQuesion(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.addQuesion(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addAnswer", method = {RequestMethod.POST})
    public WrapperResponse<Long> addAnswer(@RequestParam("id") String id,
                                           @RequestParam(value = "answerThought", required = false) String answerThought,
                                           @RequestParam("answerText") String answerText,
                                           @RequestParam(value = "answerMp3", required = false) MultipartFile answerMp3,
                                           @RequestParam(value = "answerMp3Duration", required = false) String answerMp3Duration,
                                           @RequestParam(value = "answerComment", required = false) String answerComment,
                                           @RequestParam("creator") String creator) {
        String answerMp3Ossid = null;
        if (answerMp3 != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
                String now = sdf.format(new Date());
                answerMp3Ossid = "ListeningTest[" + creator + "][" + now + "]["+answerMp3Duration+"].mp3";
                minioClient.putListeningTestMp3(answerMp3Ossid, answerMp3.getInputStream(), answerMp3.getSize(), answerMp3.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // add answer
        ListeningQADTO dto = ListeningQADTO.builder()
                .questionId(Integer.parseInt(id))
                .answerThought(answerThought)
                .answerText(answerText)
                .answerComment(answerComment)
                .answerCreator(creator).build();
        listeningBO.addAnswer(dto);

        // add mp3
        ListeningAnswerMp3DTO mp3Dto = ListeningAnswerMp3DTO.builder()
                .answerId(dto.getAnswerId())
                .answerMp3Ossid(answerMp3Ossid)
                .answerMp3Duration(Integer.parseInt(answerMp3Duration))
                .build();
        Long ret = listeningBO.addAnswerMp3(mp3Dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAnswer", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteAnswer(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.deleteAnswer(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerComment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerComment(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.updateAnswerComment(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerThought", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerThought(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.updateAnswerThought(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerText", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerText(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.updateAnswerText(dto);
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
        String answerMp3Ossid = "ListeningTest[" + creator + "][" + now + "]["+answerMp3Duration+"].mp3";

        try {
            minioClient.putListeningTestMp3(answerMp3Ossid, answerMp3.getInputStream(), answerMp3.getSize(), answerMp3.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ListeningAnswerMp3DTO dto = ListeningAnswerMp3DTO.builder()
                .answerId(Integer.parseInt(answerId))
                .answerMp3Ossid(answerMp3Ossid)
                .answerMp3Duration(Integer.parseInt(answerMp3Duration))
                .build();
        Long ret = listeningBO.addAnswerMp3(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAnswerMp3s", method = {RequestMethod.POST})
    public WrapperResponse<List<ListeningAnswerMp3DTO>> queryAnswerMp3s(@RequestBody ListeningQADTO dto) {
        List<ListeningAnswerMp3DTO> rDtos = listeningBO.queryAnswerMp3s(dto);
        return WrapperResponse.ok(rDtos);
    }

    @ResponseBody
    @RequestMapping(value = "/getAnswerMp3Url", method = {RequestMethod.POST})
    public WrapperResponse<String> getAnswerMp3Url(@RequestBody ListeningAnswerMp3DTO dto) {
        String url = minioClient.getListeningTestMp3Url(dto.getAnswerMp3Ossid());
        return WrapperResponse.ok(url);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAnswerCohesionAndCoherenceTags", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateAnswerCohesionAndCoherenceTags(@RequestBody ListeningQADTO dto) {
        Long ret = listeningBO.updateAnswerCohesionAndCoherenceTags(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/log", method = {RequestMethod.POST})
    public WrapperResponse<Long> log(@RequestBody ListeningLogDTO dto) {
        Long ret = listeningBO.log(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryListeningSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<ListeningSummaryDTO>> queryListeningSummary(@RequestBody ListeningLogDTO dto) {
        List<ListeningSummaryDTO> rDtos = listeningBO.queryListeningSummary(dto);
        return WrapperResponse.ok(rDtos);
    }



    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putListeningTestImage(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getListeningTestImageUrl(imageId);

        return WrapperResponse.ok(url);
    }
}
