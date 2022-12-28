package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.sentence.SentenceDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceGroupDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceGroupDtlDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceNewlyAddedDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SentenceDao {
    void addSentence(SentenceDO pdo);

    Long deleteSentence(@Param("uid") Integer uid);

    Long updateSentence(SentenceDO pdo);

    SentenceDO querySentence(@Param("uid") int uid);

    List<SentenceDO> querySentences(@Param("condition") String condition);

    List<SentenceNewlyAddedDO> querySentenceNewlyAdded();

    Long addSentenceGroup(SentenceGroupDO pdo);

    Long addSentenceInGroup(SentenceGroupDtlDO pdo);

    Long deleteSentenceInGroup(@Param("groupId") Integer groupId, @Param("SentenceId") Integer SentenceId);

    List<SentenceDO> querySentencesInGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
