package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WritingDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WritingBO {
    @Resource
    private WritingDAO dao;

    public List<WritingCategoryDTO> queryCatetory(WritingCategoryDTO pDto) {
        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<WritingCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            WritingCategoryDTO rDto = WritingCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public Long addSiblingCategory(WritingCategoryDTO pDto) {
        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addSiblingCategory(pDo);
        return ret;
    }

    public Long addChildCategory(WritingCategoryDTO pDto) {
        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addChildCategory(pDo);
        return ret;
    }

    public Long updateCategory(WritingCategoryDTO pDto) {
        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateCategory(pDo);
        return ret;
    }

    public List<WritingExpressionDO> queryWritings(WritingCategoryDTO pDto) {
        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<WritingExpressionDO> rDos = dao.queryWritings(pDo);
        return rDos;
    }

    public int addExpression(WritingExpressionDO pDo) {
        dao.addExpression(pDo);

        return pDo.getExpressionId();
    }

    public Long updateExpression(WritingExpressionDO pDo) {
        Long ret = dao.updateExpression(pDo);
        return ret;
    }

    public int addSample(WritingExpressionDO pDo) {
        dao.addSample(pDo);

        return pDo.getSampleId();
    }

    public Long updateSample(WritingExpressionDO pDo) {
        Long ret = dao.updateSample(pDo);
        return ret;
    }

    public Long deleteExpression(WritingExpressionDO pDo) {
        Long ret = dao.deleteExpression(pDo);
        return ret;
    }
    public Long deleteSample(WritingExpressionDO pDo) {
        Long ret = dao.deleteSample(pDo);
        return ret;
    }


    public Long log(WritingLogDO pDo) {
        Long ret = dao.log(pDo);
        return ret;
    }

    public List<WritingSummaryDTO> queryWritingSummary(WritingLogDO pDo) {
        List<WritingSummaryDO> rDos = dao.queryWritingSummary(pDo);
        return rDos.stream().map(rDo -> {
            WritingSummaryDTO rDto = WritingSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }


}
