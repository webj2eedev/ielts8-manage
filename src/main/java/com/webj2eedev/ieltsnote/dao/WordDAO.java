package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDAO {

    List<WordDO> queryWords(WordDO _do);

    WordDO queryWord(WordDO _do);

    boolean existWord(@Param("wordDO") WordDO _do);

    void addWord(WordDO _do);

    Long deleteWord(@Param("wordDO") WordDO _do);

    Long updateWordComment(@Param("wordDO") WordDO _do);

    Long updateWordTagRel(@Param("wordDO") WordDO _do);


    List<WordCntNewlyAddedDO> queryNewlyAddedWordCntSummary();
}
