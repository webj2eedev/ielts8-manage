package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.TranslationDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslationBO {
    @Resource
    private TranslationDAO dao;

    public List<TranslationCategoryDTO> queryCatetory(TranslationCategoryDTO pDto) {
        TranslationCategoryDO pDo = TranslationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<TranslationCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            TranslationCategoryDTO rDto = TranslationCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(TranslationCategoryDTO pDto) {
        TranslationCategoryDO pDo = TranslationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(TranslationCategoryDTO pDto) {
        TranslationCategoryDO pDo = TranslationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }
    public List<TranslationExpressionDTO> queryTranslations(TranslationCategoryDTO pDto) {
        TranslationCategoryDO pDo = TranslationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<TranslationExpressionDO> rDos = dao.queryTranslations(pDo);
        return rDos.stream().map(rDo -> {
            TranslationExpressionDTO rDto = TranslationExpressionDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addExpression(TranslationExpressionDTO pDto) {
        TranslationExpressionDO pDo = TranslationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addExpression(pDo);
        return pDo.getExpressionId();
    }

    public Long addSample(TranslationExpressionDTO pDto) {
        TranslationExpressionDO pDo = TranslationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addSample(pDo);
        return ret;
    }

    public Long deleteExpression(TranslationExpressionDTO pDto) {
        TranslationExpressionDO pDo = TranslationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteExpression(pDo);
        return ret;
    }
    public Long deleteSample(TranslationExpressionDTO pDto) {
        TranslationExpressionDO pDo = TranslationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteSample(pDo);
        return ret;
    }

    public Long log(TranslationLogDTO pDto) {
        TranslationLogDO pDo = TranslationLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }

    public List<TranslationSummaryDTO> queryTranslationSummary(TranslationLogDTO pDto) {
        TranslationLogDO pDo = TranslationLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<TranslationSummaryDO> rDos = dao.queryTranslationSummary(pDo);
        return rDos.stream().map(rDo -> {
            TranslationSummaryDTO rDto = TranslationSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

}
