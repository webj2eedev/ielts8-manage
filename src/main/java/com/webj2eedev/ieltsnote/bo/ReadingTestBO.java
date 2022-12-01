package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.ReadingTestDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadingTestBO {
    @Resource
    private ReadingTestDAO dao;

    public List<ReadingTestCategoryDTO> queryCatetory(ReadingTestCategoryDTO pDto) {
        ReadingTestCategoryDO pDo = ReadingTestCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingTestCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            ReadingTestCategoryDTO rDto = ReadingTestCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(ReadingTestCategoryDTO pDto) {
        ReadingTestCategoryDO pDo = ReadingTestCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(ReadingTestCategoryDTO pDto) {
        ReadingTestCategoryDO pDo = ReadingTestCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public Long updateCategory(ReadingTestCategoryDTO pDto) {
        ReadingTestCategoryDO pDo = ReadingTestCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateCategory(pDo);
        return ret;
    }

    public List<ReadingTestArticleDTO> queryArticles(ReadingTestCategoryDTO pDto) {
        ReadingTestCategoryDO pDo = ReadingTestCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingTestArticleDO> rDos = dao.queryArticles(pDo);
        return rDos.stream().map(rDo -> {
            ReadingTestArticleDTO rDto = ReadingTestArticleDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
    public int addArticle(ReadingTestArticleDTO pDto) {
        ReadingTestArticleDO pDo = ReadingTestArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addArticle(pDo);
        return pDo.getId();
    }

    public Long updateArticleContent(ReadingTestArticleDTO pDto) {
        ReadingTestArticleDO pDo = ReadingTestArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateArticleContent(pDo);
        return ret;
    }

    public Long log(ReadingTestLogDTO pDto) {
        ReadingTestLogDO pDo = ReadingTestLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }
    public List<ReadingTestSummaryDTO> queryLogSummary(ReadingTestLogDTO pDto) {
        ReadingTestLogDO pDo = ReadingTestLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingTestSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos.stream().map(rDo -> {
            ReadingTestSummaryDTO rDto = ReadingTestSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
