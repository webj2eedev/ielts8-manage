package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface ReadingTestDAO {
    List<ReadingTestCategoryDO> queryCatetory(ReadingTestCategoryDO pDo);

    int addSiblingCategory(ReadingTestCategoryDO pDo);

    int addChildCategory(ReadingTestCategoryDO pDo);

    Long updateCategory(ReadingTestCategoryDO pDo);

    List<ReadingTestArticleDO> queryArticles(ReadingTestCategoryDO pDo);

    int addArticle(ReadingTestArticleDO pDo);

    Long updateArticleContent(ReadingTestArticleDO pDo);

    Long log(ReadingTestLogDO pDo);
    List<ReadingTestSummaryDO> queryLogSummary(ReadingTestLogDO pDo);

}
