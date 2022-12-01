package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface WritingDAO {
    List<WritingCategoryDO> queryCatetory(WritingCategoryDO pDo);

    Long addSiblingCategory(WritingCategoryDO pDo);

    Long addChildCategory(WritingCategoryDO pDo);

    Long updateCategory(WritingCategoryDO pDo);

    List<WritingExpressionDO> queryWritings(WritingCategoryDO pDo);

    int addExpression(WritingExpressionDO pDo);

    Long updateExpression(WritingExpressionDO pDo);

    Long addSample(WritingExpressionDO pDo);

    Long updateSample(WritingExpressionDO pDo);

    Long deleteExpression(WritingExpressionDO pDo);

    Long deleteSample(WritingExpressionDO pDo);

    Long log(WritingLogDO pDo);

    List<WritingSummaryDO> queryWritingSummary(WritingLogDO pDo);
}
