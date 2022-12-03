package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import com.webj2eedev.ieltsnote.entity.WordlistRefDO;
import com.webj2eedev.ieltsnote.entity.WordlistRefWordDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordlistDao {
    void addWord(WordDO pdo);

    Long deleteWord(@Param("uid") Integer uid);

    Long updateWord(WordDO pdo);

    WordDO queryWord(@Param("word") String word);
    List<WordDO> queryWords(@Param("condition") String condition);

    boolean existWord(@Param("word") String word);

    List<WordCntNewlyAddedDO> queryNewlyAddedWordCntSummary();

    Long createRef(WordlistRefDO pdo);

    Long addRefWord(WordlistRefWordDO pdo);

    Long deleteRefWord(@Param("refId") Integer refId, @Param("wordId") Integer wordId);

    List<WordDO> queryRefWords(@Param("refId") int refId, @Param("condition") String condition);
}
