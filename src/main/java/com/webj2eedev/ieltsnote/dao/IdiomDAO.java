package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.IdiomCategoryDO;
import com.webj2eedev.ieltsnote.entity.IdiomExpressionDO;
import com.webj2eedev.ieltsnote.entity.IdiomLogDO;
import com.webj2eedev.ieltsnote.entity.IdiomSummaryDO;

import java.util.List;

public interface IdiomDAO {
    List<IdiomCategoryDO> queryCatetory(IdiomCategoryDO pDo);

    int addSiblingCategory(IdiomCategoryDO pDo);

    int addChildCategory(IdiomCategoryDO pDo);

    List<IdiomExpressionDO> queryIdioms(IdiomCategoryDO pDo);

    int addExpression(IdiomExpressionDO pDo);

    Long addSample(IdiomExpressionDO pDo);

    Long deleteExpression(IdiomExpressionDO pDo);

    Long deleteSample(IdiomExpressionDO pDo);

    Long log(IdiomLogDO pDo);

    List<IdiomSummaryDO> queryIdiomSummary(IdiomLogDO pDo);
}
