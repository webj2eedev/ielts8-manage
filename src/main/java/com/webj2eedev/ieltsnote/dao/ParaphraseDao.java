package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.paraphrase.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParaphraseDao {
    void addParaphrase(ParaphraseDO pdo);

    Long deleteParaphrase(@Param("uid") Integer uid);

    Long updateParaphrase(ParaphraseDO pdo);

    List<ParaphraseDO> queryParaphrases(@Param("condition") String condition);

    List<ParaphraseNewlyAddedDO> queryParaphraseNewlyAdded();

    //////////////////////////////////////////////////

    void addParaphraseRewrite(ParaphraseRewriteDO pdo);

    //////////////////////////////////////////////////

    Long addParaphraseGroup(ParaphraseGroupDO pdo);

    Long addParaphraseInGroup(ParaphraseGroupDtlDO pdo);

    Long deleteParaphraseInGroup(@Param("groupId") Integer groupId, @Param("paraphraseId") Integer ParaphraseId);

    List<ParaphraseDO> queryParaphrasesInGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
