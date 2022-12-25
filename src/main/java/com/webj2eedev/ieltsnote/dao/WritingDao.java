package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.dto.writing.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.writing.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.writing.WritingCategoryDO;

import java.util.List;

public interface WritingDao {
    List<WritingCategoryDO> queryCatetory();

    Long addSiblingCategory(AddSiblingCategoryDTO pdto);

    Long addChildCategory(AddChildCategoryDTO pdto);

    Long updateCategory(WritingCategoryDO pDo);

//    List<WritingExpressionDO> queryWritings(WritingCategoryDO pDo);
//
//    int addExpression(WritingExpressionDO pDo);
//
//    Long updateExpression(WritingExpressionDO pDo);
//
//    Long addSample(WritingExpressionDO pDo);
//
//    Long updateSample(WritingExpressionDO pDo);
//
//    Long deleteExpression(WritingExpressionDO pDo);
//
//    Long deleteSample(WritingExpressionDO pDo);
//
//    Long log(WritingLogDO pDo);
//
//    List<WritingSummaryDO> queryWritingSummary(WritingLogDO pDo);
}
