package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.SynonymsSubstitutionDAO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionArticleDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionCategoryDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionLogDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionSummaryDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SynonymsSubstitutionBO {
    @Resource
    private SynonymsSubstitutionDAO dao;

    public List<SynonymsSubstitutionCategoryDO> queryCatetory(SynonymsSubstitutionCategoryDO pDo) {
        List<SynonymsSubstitutionCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos;
    }

    public int addSiblingCategory(SynonymsSubstitutionCategoryDO pDo) {
        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(SynonymsSubstitutionCategoryDO pDo) {
        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public List<SynonymsSubstitutionArticleDO> queryArticles(SynonymsSubstitutionCategoryDO pDo) {
        List<SynonymsSubstitutionArticleDO> rDos = dao.queryArticles(pDo);
        return rDos;
    }
    public int addArticle(SynonymsSubstitutionArticleDO pDo) {
        dao.addArticle(pDo);
        return pDo.getId();
    }

    public Long updateArticle(SynonymsSubstitutionArticleDO pDo) {
        Long ret = dao.updateArticle(pDo);
        return ret;
    }

    public Long log(SynonymsSubstitutionLogDO pDo) {
        Long ret = dao.log(pDo);
        return ret;
    }
    public List<SynonymsSubstitutionSummaryDO> queryLogSummary(SynonymsSubstitutionLogDO pDo) {
        List<SynonymsSubstitutionSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos;
    }
}
