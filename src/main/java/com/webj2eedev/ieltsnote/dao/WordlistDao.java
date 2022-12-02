package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.WordDO;
import org.apache.ibatis.annotations.Param;

public interface WordlistDao {
    void addWord(WordDO pdo);

    Long deleteWord(@Param("word") String word);

    Long updateWord(WordDO pdo);

    WordDO queryWord(@Param("word") String word);

    boolean existWord(@Param("word") String word);
}
