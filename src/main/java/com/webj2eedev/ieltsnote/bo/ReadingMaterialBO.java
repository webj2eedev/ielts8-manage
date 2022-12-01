package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.ReadingMaterialDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadingMaterialBO {
    @Resource
    private ReadingMaterialDAO dao;

    public List<ReadingMaterialCategoryDTO> queryCatetory(ReadingMaterialCategoryDTO pDto) {
        ReadingMaterialCategoryDO pDo = ReadingMaterialCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingMaterialCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            ReadingMaterialCategoryDTO rDto = ReadingMaterialCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(ReadingMaterialCategoryDTO pDto) {
        ReadingMaterialCategoryDO pDo = ReadingMaterialCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(ReadingMaterialCategoryDTO pDto) {
        ReadingMaterialCategoryDO pDo = ReadingMaterialCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public List<ReadingMaterialArticleDTO> queryArticles(ReadingMaterialCategoryDTO pDto) {
        ReadingMaterialCategoryDO pDo = ReadingMaterialCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingMaterialArticleDO> rDos = dao.queryArticles(pDo);
        return rDos.stream().map(rDo -> {
            ReadingMaterialArticleDTO rDto = ReadingMaterialArticleDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
    public int addArticle(ReadingMaterialArticleDTO pDto) {
        ReadingMaterialArticleDO pDo = ReadingMaterialArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addArticle(pDo);
        return pDo.getId();
    }

    public Long updateArticleContent(ReadingMaterialArticleDTO pDto) {
        ReadingMaterialArticleDO pDo = ReadingMaterialArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateArticleContent(pDo);
        return ret;
    }

    public Long log(ReadingMaterialLogDTO pDto) {
        ReadingMaterialLogDO pDo = ReadingMaterialLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }
    public List<ReadingMaterialSummaryDTO> queryLogSummary(ReadingMaterialLogDTO pDto) {
        ReadingMaterialLogDO pDo = ReadingMaterialLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<ReadingMaterialSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos.stream().map(rDo -> {
            ReadingMaterialSummaryDTO rDto = ReadingMaterialSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
