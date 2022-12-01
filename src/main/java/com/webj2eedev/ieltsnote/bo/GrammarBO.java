package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.GrammarDAO;
import com.webj2eedev.ieltsnote.dto.GrammarArticleDTO;
import com.webj2eedev.ieltsnote.dto.GrammarCategoryDTO;
import com.webj2eedev.ieltsnote.dto.GrammarLogDTO;
import com.webj2eedev.ieltsnote.dto.GrammarSummaryDTO;
import com.webj2eedev.ieltsnote.entity.GrammarArticleDO;
import com.webj2eedev.ieltsnote.entity.GrammarCategoryDO;
import com.webj2eedev.ieltsnote.entity.GrammarLogDO;
import com.webj2eedev.ieltsnote.entity.GrammarSummaryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrammarBO {
    @Resource
    private GrammarDAO dao;

    public List<GrammarCategoryDTO> queryCatetory(GrammarCategoryDTO pDto) {
        GrammarCategoryDO pDo = GrammarCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<GrammarCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            GrammarCategoryDTO rDto = GrammarCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(GrammarCategoryDTO pDto) {
        GrammarCategoryDO pDo = GrammarCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(GrammarCategoryDTO pDto) {
        GrammarCategoryDO pDo = GrammarCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public List<GrammarArticleDTO> queryArticles(GrammarCategoryDTO pDto) {
        GrammarCategoryDO pDo = GrammarCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<GrammarArticleDO> rDos = dao.queryArticles(pDo);
        return rDos.stream().map(rDo -> {
            GrammarArticleDTO rDto = GrammarArticleDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
    public int addArticle(GrammarArticleDTO pDto) {
        GrammarArticleDO pDo = GrammarArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addArticle(pDo);
        return pDo.getId();
    }

    public Long updateArticleContent(GrammarArticleDTO pDto) {
        GrammarArticleDO pDo = GrammarArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateArticleContent(pDo);
        return ret;
    }

    public Long log(GrammarLogDTO pDto) {
        GrammarLogDO pDo = GrammarLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }
    public List<GrammarSummaryDTO> queryLogSummary(GrammarLogDTO pDto) {
        GrammarLogDO pDo = GrammarLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<GrammarSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos.stream().map(rDo -> {
            GrammarSummaryDTO rDto = GrammarSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
