package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface CollocationDAO {
    List<CollocationCategoryDO> queryCatetory(CollocationCategoryDO pDo);

    Long addSiblingCategory(CollocationCategoryDO pDo);

    Long addChildCategory(CollocationCategoryDO pDo);

    List<CollocationExpressionDO> queryCollocations(CollocationCategoryDO pDo);

    Long addExpression(CollocationExpressionDO pDo);

    Long addSample(CollocationExpressionDO pDo);

    Long deleteExpression(CollocationExpressionDO pDo);

    Long deleteSample(CollocationExpressionDO pDo);

    Long log(CollocationLogDO pDo);

    List<CollocationSummaryDO> queryCollocationSummary(CollocationLogDO pDo);
}
