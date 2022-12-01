package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface WordDictationDAO {
    int createDictationSession(WordDictationSessionDO params);

    Long completeDictationSession(WordDictationSessionDO params);

    Long cancelDictationSession(WordDictationSessionDO params);

    int createDictationSessionDetail(WordDictationSessionDO params);

    WordDictationSessionDO queryDictationSession(WordDictationSessionDO params);
    Long addDictationSessionProgress(WordDictationProgressDO params);


    List<WordDictationProgressSummaryDO> queryDictationProgressSummary(WordDictationSessionDO params);


    List<DictationWordDO> generateDictationWordList(WordDictationSessionDO params);


    List<WordDO> queryDictationReportDontknowWordList(WordDictationSessionDO params);
}
