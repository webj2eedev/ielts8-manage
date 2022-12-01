package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionArticleDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionCategoryDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionLogDO;
import com.webj2eedev.ieltsnote.entity.SynonymsSubstitutionSummaryDO;

import java.util.List;

public interface SynonymsSubstitutionDAO {
    List<SynonymsSubstitutionCategoryDO> queryCatetory(SynonymsSubstitutionCategoryDO pDo);

    int addSiblingCategory(SynonymsSubstitutionCategoryDO pDo);

    int addChildCategory(SynonymsSubstitutionCategoryDO pDo);

    List<SynonymsSubstitutionArticleDO> queryArticles(SynonymsSubstitutionCategoryDO pDo);

    int addArticle(SynonymsSubstitutionArticleDO pDo);

    Long updateArticle(SynonymsSubstitutionArticleDO pDo);

    Long log(SynonymsSubstitutionLogDO pDo);
    List<SynonymsSubstitutionSummaryDO> queryLogSummary(SynonymsSubstitutionLogDO pDo);

}
