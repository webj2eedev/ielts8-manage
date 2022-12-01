package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.CollocationDAO;
import com.webj2eedev.ieltsnote.dto.CollocationCategoryDTO;
import com.webj2eedev.ieltsnote.dto.CollocationExpressionDTO;
import com.webj2eedev.ieltsnote.dto.CollocationLogDTO;
import com.webj2eedev.ieltsnote.dto.CollocationSummaryDTO;
import com.webj2eedev.ieltsnote.entity.CollocationCategoryDO;
import com.webj2eedev.ieltsnote.entity.CollocationExpressionDO;
import com.webj2eedev.ieltsnote.entity.CollocationLogDO;
import com.webj2eedev.ieltsnote.entity.CollocationSummaryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollocationBO {
    @Resource
    private CollocationDAO dao;

    public List<CollocationCategoryDTO> queryCatetory(CollocationCategoryDTO pDto) {
        CollocationCategoryDO pDo = CollocationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CollocationCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            CollocationCategoryDTO rDto = CollocationCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public Integer addSiblingCategory(CollocationCategoryDTO pDto) {
        CollocationCategoryDO pDo = CollocationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);

        return pDo.getId();
    }

    public Long addChildCategory(CollocationCategoryDTO pDto) {
        CollocationCategoryDO pDo = CollocationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addChildCategory(pDo);
        return ret;
    }
    public List<CollocationExpressionDTO> queryCollocations(CollocationCategoryDTO pDto) {
        CollocationCategoryDO pDo = CollocationCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CollocationExpressionDO> rDos = dao.queryCollocations(pDo);
        return rDos.stream().map(rDo -> {
            CollocationExpressionDTO rDto = CollocationExpressionDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addExpression(CollocationExpressionDTO pDto) {
        CollocationExpressionDO pDo = CollocationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addExpression(pDo);
        return pDo.getExpressionId();
    }

    public Long addSample(CollocationExpressionDTO pDto) {
        CollocationExpressionDO pDo = CollocationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addSample(pDo);
        return ret;
    }

    public Long deleteExpression(CollocationExpressionDTO pDto) {
        CollocationExpressionDO pDo = CollocationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteExpression(pDo);
        return ret;
    }
    public Long deleteSample(CollocationExpressionDTO pDto) {
        CollocationExpressionDO pDo = CollocationExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteSample(pDo);
        return ret;
    }

    public Long log(CollocationLogDTO pDto) {
        CollocationLogDO pDo = CollocationLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }

    public List<CollocationSummaryDTO> queryCollocationSummary(CollocationLogDTO pDto) {
        CollocationLogDO pDo = CollocationLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<CollocationSummaryDO> rDos = dao.queryCollocationSummary(pDo);
        return rDos.stream().map(rDo -> {
            CollocationSummaryDTO rDto = CollocationSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
