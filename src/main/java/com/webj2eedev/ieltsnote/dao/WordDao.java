package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.word.WordNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.word.WordDO;
import com.webj2eedev.ieltsnote.entity.word.WordGroupDO;
import com.webj2eedev.ieltsnote.entity.word.WordGroupDtlDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDao {
    void addWord(WordDO pdo);

    Long deleteWord(@Param("uid") Integer uid);

    Long updateWord(WordDO pdo);

    WordDO queryWord(@Param("word") String word);
    List<WordDO> queryWords(@Param("condition") String condition);

    boolean existWord(@Param("word") String word);

    List<WordNewlyAddedDO> summarizeWordNewlyAdded();

    Long addWordGroup(WordGroupDO pdo);

    Long addWordInWordGroup(WordGroupDtlDO pdo);

    Long deleteWordInGroup(@Param("groupId") Integer groupId, @Param("wordId") Integer wordId);

    List<WordDO> queryWordsInWordGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
