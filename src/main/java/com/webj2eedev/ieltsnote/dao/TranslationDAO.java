package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface TranslationDAO {
    List<TranslationCategoryDO> queryCatetory(TranslationCategoryDO pDo);

    int addSiblingCategory(TranslationCategoryDO pDo);

    int addChildCategory(TranslationCategoryDO pDo);

    List<TranslationExpressionDO> queryTranslations(TranslationCategoryDO pDo);

    int addExpression(TranslationExpressionDO pDo);

    Long addSample(TranslationExpressionDO pDo);

    Long deleteExpression(TranslationExpressionDO pDo);

    Long deleteSample(TranslationExpressionDO pDo);

    Long log(TranslationLogDO pDo);

    List<TranslationSummaryDO> queryTranslationSummary(TranslationLogDO pDo);
}
