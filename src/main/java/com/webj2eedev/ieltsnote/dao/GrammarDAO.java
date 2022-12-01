package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.GrammarArticleDO;
import com.webj2eedev.ieltsnote.entity.GrammarCategoryDO;
import com.webj2eedev.ieltsnote.entity.GrammarLogDO;
import com.webj2eedev.ieltsnote.entity.GrammarSummaryDO;

import java.util.List;

public interface GrammarDAO {
    List<GrammarCategoryDO> queryCatetory(GrammarCategoryDO pDo);

    int addSiblingCategory(GrammarCategoryDO pDo);

    int addChildCategory(GrammarCategoryDO pDo);

    List<GrammarArticleDO> queryArticles(GrammarCategoryDO pDo);

    int addArticle(GrammarArticleDO pDo);

    Long updateArticleContent(GrammarArticleDO pDo);

    Long log(GrammarLogDO pDo);
    List<GrammarSummaryDO> queryLogSummary(GrammarLogDO pDo);

}
