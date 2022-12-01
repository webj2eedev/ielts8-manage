package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.BgknowledgeDAO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeArticleDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeCategoryDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeLogDTO;
import com.webj2eedev.ieltsnote.dto.BgknowledgeSummaryDTO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeArticleDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeCategoryDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeLogDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeSummaryDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BgknowledgeBO {
    @Resource
    private BgknowledgeDAO dao;

    public List<BgknowledgeCategoryDTO> queryCatetory(BgknowledgeCategoryDTO pDto) {
        BgknowledgeCategoryDO pDo = BgknowledgeCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<BgknowledgeCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            BgknowledgeCategoryDTO rDto = BgknowledgeCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(BgknowledgeCategoryDTO pDto) {
        BgknowledgeCategoryDO pDo = BgknowledgeCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(BgknowledgeCategoryDTO pDto) {
        BgknowledgeCategoryDO pDo = BgknowledgeCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public List<BgknowledgeArticleDTO> queryArticles(BgknowledgeCategoryDTO pDto) {
        BgknowledgeCategoryDO pDo = BgknowledgeCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<BgknowledgeArticleDO> rDos = dao.queryArticles(pDo);
        return rDos.stream().map(rDo -> {
            BgknowledgeArticleDTO rDto = BgknowledgeArticleDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
    public int addArticle(BgknowledgeArticleDTO pDto) {
        BgknowledgeArticleDO pDo = BgknowledgeArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addArticle(pDo);
        return pDo.getId();
    }

    public Long updateArticleContent(BgknowledgeArticleDTO pDto) {
        BgknowledgeArticleDO pDo = BgknowledgeArticleDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateArticleContent(pDo);
        return ret;
    }

    public Long log(BgknowledgeLogDTO pDto) {
        BgknowledgeLogDO pDo = BgknowledgeLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.log(pDo);
        return ret;
    }
    public List<BgknowledgeSummaryDTO> queryLogSummary(BgknowledgeLogDTO pDto) {
        BgknowledgeLogDO pDo = BgknowledgeLogDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<BgknowledgeSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos.stream().map(rDo -> {
            BgknowledgeSummaryDTO rDto = BgknowledgeSummaryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }
}
