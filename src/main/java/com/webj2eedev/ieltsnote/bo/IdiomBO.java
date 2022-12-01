package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.IdiomDAO;
import com.webj2eedev.ieltsnote.dto.IdiomCategoryDTO;
import com.webj2eedev.ieltsnote.dto.IdiomExpressionDTO;
import com.webj2eedev.ieltsnote.dto.IdiomLogDTO;
import com.webj2eedev.ieltsnote.dto.IdiomSummaryDTO;
import com.webj2eedev.ieltsnote.entity.IdiomCategoryDO;
import com.webj2eedev.ieltsnote.entity.IdiomExpressionDO;
import com.webj2eedev.ieltsnote.entity.IdiomLogDO;
import com.webj2eedev.ieltsnote.entity.IdiomSummaryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdiomBO {
    @Resource
    private IdiomDAO dao;

    public List<IdiomCategoryDTO> queryCatetory(IdiomCategoryDTO pDto) {
        IdiomCategoryDO pDo = IdiomCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<IdiomCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            IdiomCategoryDTO rDto = IdiomCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(IdiomCategoryDTO pDto) {
        IdiomCategoryDO pDo = IdiomCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(IdiomCategoryDTO pDto) {
        IdiomCategoryDO pDo = IdiomCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }
    public List<IdiomExpressionDTO> queryIdioms(IdiomCategoryDTO pDto) {
        IdiomCategoryDO pDo = IdiomCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<IdiomExpressionDO> rDos = dao.queryIdioms(pDo);
        return rDos.stream().map(rDo -> {
            IdiomExpressionDTO rDto = IdiomExpressionDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addExpression(IdiomExpressionDTO pDto) {
        IdiomExpressionDO pDo = IdiomExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addExpression(pDo);
        return pDo.getExpressionId();
    }

    public Long addSample(IdiomExpressionDTO pDto) {
        IdiomExpressionDO pDo = IdiomExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addSample(pDo);
        return ret;
    }

    public Long deleteExpression(IdiomExpressionDTO pDto) {
        IdiomExpressionDO pDo = IdiomExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteExpression(pDo);
        return ret;
    }
    public Long deleteSample(IdiomExpressionDTO pDto) {
        IdiomExpressionDO pDo = IdiomExpressionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.deleteSample(pDo);
        return ret;
    }

    public Long log(IdiomLogDTO pDto) {
        IdiomLogDO pDo = IdiomLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }

    public List<IdiomSummaryDTO> querySummary(IdiomLogDTO pDto) {
        IdiomLogDO pDo = IdiomLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<IdiomSummaryDO> rDos = dao.queryIdiomSummary(pDo);
        return rDos.stream().map(rDo -> {
            IdiomSummaryDTO rDto = IdiomSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

}
