package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.CohesionAndCoherenceDAO;
import com.webj2eedev.ieltsnote.dto.CohesionAndCoherenceCategoryDTO;
import com.webj2eedev.ieltsnote.dto.CohesionAndCoherenceExpressionDTO;
import com.webj2eedev.ieltsnote.dto.CCLogDTO;
import com.webj2eedev.ieltsnote.dto.CCSummaryDTO;
import com.webj2eedev.ieltsnote.entity.CohesionAndCoherenceCategoryDO;
import com.webj2eedev.ieltsnote.entity.CohesionAndCoherenceExpressionDO;
import com.webj2eedev.ieltsnote.entity.CCLogDO;
import com.webj2eedev.ieltsnote.entity.CCSummaryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CohesionAndCoherenceBO {
    @Resource
    private CohesionAndCoherenceDAO dao;

    public List<CohesionAndCoherenceCategoryDTO> queryCatetory(CohesionAndCoherenceCategoryDTO pDto) {
        CohesionAndCoherenceCategoryDO pDo = CohesionAndCoherenceCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CohesionAndCoherenceCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            CohesionAndCoherenceCategoryDTO rDto = CohesionAndCoherenceCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(CohesionAndCoherenceCategoryDTO pDto) {
        CohesionAndCoherenceCategoryDO pDo = CohesionAndCoherenceCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public Long addChildCategory(CohesionAndCoherenceCategoryDTO pDto) {
        CohesionAndCoherenceCategoryDO pDo = CohesionAndCoherenceCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addChildCategory(pDo);
        return ret;
    }
    public List<CohesionAndCoherenceExpressionDTO> queryCCs(CohesionAndCoherenceCategoryDTO pDto) {
        CohesionAndCoherenceCategoryDO pDo = CohesionAndCoherenceCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CohesionAndCoherenceExpressionDO> rDos = dao.queryCCs(pDo);
        return rDos.stream().map(rDo -> {
            CohesionAndCoherenceExpressionDTO rDto = CohesionAndCoherenceExpressionDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addExpression(CohesionAndCoherenceExpressionDTO pDto) {
        CohesionAndCoherenceExpressionDO pDo = CohesionAndCoherenceExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addExpression(pDo);
        return pDo.getExpressionId();
    }

    public Long addSample(CohesionAndCoherenceExpressionDTO pDto) {
        CohesionAndCoherenceExpressionDO pDo = CohesionAndCoherenceExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addSample(pDo);
        return ret;
    }

    public Long deleteExpression(CohesionAndCoherenceExpressionDTO pDto) {
        CohesionAndCoherenceExpressionDO pDo = CohesionAndCoherenceExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteExpression(pDo);
        return ret;
    }
    public Long deleteSample(CohesionAndCoherenceExpressionDTO pDto) {
        CohesionAndCoherenceExpressionDO pDo = CohesionAndCoherenceExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteSample(pDo);
        return ret;
    }


    public Long log(CCLogDTO pDto) {
        CCLogDO pDo = CCLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }

    public List<CCSummaryDTO> queryCCSummary(CCLogDTO pDto) {
        CCLogDO pDo = CCLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CCSummaryDO> rDos = dao.queryCCSummary(pDo);
        return rDos.stream().map(rDo -> {
            CCSummaryDTO rDto = CCSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
