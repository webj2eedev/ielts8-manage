package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.SpeakingDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpeakingBO {
    @Resource
    private SpeakingDAO speakingDAO;

    public List<SpeakingCategoryDO> queryCatetory(SpeakingCategoryDO pDo) {
        List<SpeakingCategoryDO> rDos = speakingDAO.queryCatetory(pDo);
        return rDos;
    }

    public Long addSiblingCategory(SpeakingCategoryDO pDo) {
        Long ret = speakingDAO.addSiblingCategory(pDo);
        return ret;
    }

    public Long addChildCategory(SpeakingCategoryDO pDo) {
        Long ret = speakingDAO.addChildCategory(pDo);
        return ret;
    }

    public Long updateCategory(SpeakingCategoryDO pDo) {
        Long ret = speakingDAO.updateCategory(pDo);
        return ret;
    }

    public List<SpeakingQADTO> queryQAs(SpeakingCategoryDO pDo) {
        List<SpeakingQADO> rDos = speakingDAO.queryQAs(pDo);
        return rDos.stream().map(rDo -> {
            SpeakingQADTO rDto = SpeakingQADTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public List<SpeakingQADO> filterQAs(SpeakingQAFilterDO pDo) {
        List<SpeakingQADO> rDos = speakingDAO.filterQAs(pDo);
        return rDos;
    }


    public Long addQuesion(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.addQuesion(pDo);
        return ret;
    }


    public Long updateQuestion(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.updateQuestion(pDo);
        return ret;
    }

    public Long addAnswer(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.addAnswer(pDo);

        pDto.setAnswerId(pDo.getAnswerId()); // TODO 小项目真是没必要....

        return ret;
    }

    public Long deleteAnswer(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.deleteAnswer(pDo);
        return ret;
    }


    public Long updateAnswerComment(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.updateAnswerComment(pDo);
        return ret;
    }

    public Long updateAnswerThought(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.updateAnswerThought(pDo);
        return ret;
    }

    public Long updateAnswerText(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.updateAnswerText(pDo);
        return ret;
    }

    public Long addAnswerMp3(SpeakingAnswerMp3DTO pDto) {
        SpeakingAnswerMp3DO pDo = SpeakingAnswerMp3DO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.addAnswerMp3(pDo);
        return ret;
    }

    public List<SpeakingAnswerMp3DTO> queryAnswerMp3s(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<SpeakingAnswerMp3DO> rDos = speakingDAO.queryAnswerMp3s(pDo);
        return rDos.stream().map(rDo -> {
            SpeakingAnswerMp3DTO rDto = SpeakingAnswerMp3DTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }


    public Long updateAnswerCohesionAndCoherenceTags(SpeakingQADTO pDto) {
        SpeakingQADO pDo = SpeakingQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.updateAnswerCohesionAndCoherenceTags(pDo);
        return ret;
    }


    public Long log(SpeakingLogDTO pDto) {
        SpeakingLogDO pDo = SpeakingLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = speakingDAO.log(pDo);
        return ret;
    }

    public List<SpeakingSummaryDTO> querySpeakingSummary(SpeakingLogDTO pDto) {
        SpeakingLogDO pDo = SpeakingLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<SpeakingSummaryDO> rDos = speakingDAO.querySpeakingSummary(pDo);
        return rDos.stream().map(rDo -> {
            SpeakingSummaryDTO rDto = SpeakingSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public List<SpeakingRecentWorkDO> queryRecentWork() {
        List<SpeakingRecentWorkDO> rDos = speakingDAO.queryRecentWork();
        return rDos;
    }
}
