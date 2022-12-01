package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface CohesionAndCoherenceDAO {
    List<CohesionAndCoherenceCategoryDO> queryCatetory(CohesionAndCoherenceCategoryDO pDo);

    Long addSiblingCategory(CohesionAndCoherenceCategoryDO pDo);

    Long addChildCategory(CohesionAndCoherenceCategoryDO pDo);

    List<CohesionAndCoherenceExpressionDO> queryCCs(CohesionAndCoherenceCategoryDO pDo);

    int addExpression(CohesionAndCoherenceExpressionDO pDo);

    Long addSample(CohesionAndCoherenceExpressionDO pDo);

    Long deleteExpression(CohesionAndCoherenceExpressionDO pDo);

    Long deleteSample(CohesionAndCoherenceExpressionDO pDo);


    Long log(CCLogDO pDo);

    List<CCSummaryDO> queryCCSummary(CCLogDO pDo);
}
