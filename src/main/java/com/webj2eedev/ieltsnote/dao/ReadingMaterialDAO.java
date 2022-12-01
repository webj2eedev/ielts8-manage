package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface ReadingMaterialDAO {
    List<ReadingMaterialCategoryDO> queryCatetory(ReadingMaterialCategoryDO pDo);

    int addSiblingCategory(ReadingMaterialCategoryDO pDo);

    int addChildCategory(ReadingMaterialCategoryDO pDo);

    List<ReadingMaterialArticleDO> queryArticles(ReadingMaterialCategoryDO pDo);

    int addArticle(ReadingMaterialArticleDO pDo);

    Long updateArticleContent(ReadingMaterialArticleDO pDo);

    Long log(ReadingMaterialLogDO pDo);
    List<ReadingMaterialSummaryDO> queryLogSummary(ReadingMaterialLogDO pDo);

}
