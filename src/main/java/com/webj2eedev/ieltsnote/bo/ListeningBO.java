package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.ListeningDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListeningBO {
    @Resource
    private ListeningDAO listeningDAO;

    public List<ListeningCategoryDTO> queryCatetory(ListeningCategoryDTO pDto) {
        ListeningCategoryDO pDo = ListeningCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ListeningCategoryDO> rDos = listeningDAO.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            ListeningCategoryDTO rDto = ListeningCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public Long addSiblingCategory(ListeningCategoryDTO pDto) {
        ListeningCategoryDO pDo = ListeningCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.addSiblingCategory(pDo);
        return ret;
    }

    public Long addChildCategory(ListeningCategoryDTO pDto) {
        ListeningCategoryDO pDo = ListeningCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.addChildCategory(pDo);
        return ret;
    }

    public Long updateCategory(ListeningCategoryDTO pDto) {
        ListeningCategoryDO pDo = ListeningCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.updateCategory(pDo);
        return ret;
    }

    public List<ListeningQADTO> queryQAs(ListeningCategoryDTO pDto) {
        ListeningCategoryDO pDo = ListeningCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ListeningQADO> rDos = listeningDAO.queryQAs(pDo);
        return rDos.stream().map(rDo -> {
            ListeningQADTO rDto = ListeningQADTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public Long addQuesion(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.addQuesion(pDo);
        return ret;
    }

    public Long addAnswer(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.addAnswer(pDo);

        pDto.setAnswerId(pDo.getAnswerId()); // TODO 小项目真是没必要....

        return ret;
    }

    public Long deleteAnswer(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.deleteAnswer(pDo);
        return ret;
    }


    public Long updateAnswerComment(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.updateAnswerComment(pDo);
        return ret;
    }

    public Long updateAnswerThought(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.updateAnswerThought(pDo);
        return ret;
    }

    public Long updateAnswerText(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.updateAnswerText(pDo);
        return ret;
    }

    public Long addAnswerMp3(ListeningAnswerMp3DTO pDto) {
        ListeningAnswerMp3DO pDo = ListeningAnswerMp3DO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.addAnswerMp3(pDo);
        return ret;
    }

    public List<ListeningAnswerMp3DTO> queryAnswerMp3s(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ListeningAnswerMp3DO> rDos = listeningDAO.queryAnswerMp3s(pDo);
        return rDos.stream().map(rDo -> {
            ListeningAnswerMp3DTO rDto = ListeningAnswerMp3DTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }


    public Long updateAnswerCohesionAndCoherenceTags(ListeningQADTO pDto) {
        ListeningQADO pDo = ListeningQADO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.updateAnswerCohesionAndCoherenceTags(pDo);
        return ret;
    }

    public Long log(ListeningLogDTO pDto) {
        ListeningLogDO pDo = ListeningLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = listeningDAO.log(pDo);
        return ret;
    }

    public List<ListeningSummaryDTO> queryListeningSummary(ListeningLogDTO pDto) {
        ListeningLogDO pDo = ListeningLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ListeningSummaryDO> rDos = listeningDAO.queryListeningSummary(pDo);
        return rDos.stream().map(rDo -> {
            ListeningSummaryDTO rDto = ListeningSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }


}
