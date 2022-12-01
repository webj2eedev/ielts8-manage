package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface SpeakingDAO {
    List<SpeakingCategoryDO> queryCatetory(SpeakingCategoryDO pDo);

    Long addSiblingCategory(SpeakingCategoryDO pDo);

    Long addChildCategory(SpeakingCategoryDO pDo);

    Long updateCategory(SpeakingCategoryDO pDo);


    List<SpeakingQADO> queryQAs(SpeakingCategoryDO pDo);
    List<SpeakingQADO> filterQAs(SpeakingQAFilterDO pDo);

    Long addQuesion(SpeakingQADO pDo);

    Long updateQuestion(SpeakingQADO pDo);

    Long addAnswer(SpeakingQADO pDo);
    Long deleteAnswer(SpeakingQADO pDo);

    Long updateAnswerComment(SpeakingQADO pDo);
    Long updateAnswerThought(SpeakingQADO pDo);
    Long updateAnswerText(SpeakingQADO pDo);

    Long addAnswerMp3(SpeakingAnswerMp3DO pDo);

    List<SpeakingAnswerMp3DO> queryAnswerMp3s(SpeakingQADO pDo);

    Long updateAnswerCohesionAndCoherenceTags(SpeakingQADO pDo);

    Long log(SpeakingLogDO pDo);

    List<SpeakingSummaryDO> querySpeakingSummary(SpeakingLogDO pDo);

    List<SpeakingRecentWorkDO> queryRecentWork();

}
