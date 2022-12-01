package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface ListeningDAO {
    List<ListeningCategoryDO> queryCatetory(ListeningCategoryDO pDo);

    Long addSiblingCategory(ListeningCategoryDO pDo);

    Long addChildCategory(ListeningCategoryDO pDo);

    Long updateCategory(ListeningCategoryDO pDo);

    List<ListeningQADO> queryQAs(ListeningCategoryDO pDo);

    Long addQuesion(ListeningQADO pDo);

    Long addAnswer(ListeningQADO pDo);
    Long deleteAnswer(ListeningQADO pDo);

    Long updateAnswerComment(ListeningQADO pDo);
    Long updateAnswerThought(ListeningQADO pDo);
    Long updateAnswerText(ListeningQADO pDo);

    Long addAnswerMp3(ListeningAnswerMp3DO pDo);

    List<ListeningAnswerMp3DO> queryAnswerMp3s(ListeningQADO pDo);

    Long updateAnswerCohesionAndCoherenceTags(ListeningQADO pDo);

    Long log(ListeningLogDO pDo);

    List<ListeningSummaryDO> queryListeningSummary(ListeningLogDO pDo);
}
