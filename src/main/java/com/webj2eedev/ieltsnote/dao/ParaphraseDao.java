package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseDO;
import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseGroupDO;
import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseGroupDtlDO;
import com.webj2eedev.ieltsnote.entity.paraphrase.ParaphraseNewlyAddedDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParaphraseDao {
    void addParaphrase(ParaphraseDO pdo);

    Long deleteParaphrase(@Param("uid") Integer uid);

    Long updateParaphrase(ParaphraseDO pdo);

    ParaphraseDO queryParaphrase(@Param("uid") int uid);

    List<ParaphraseDO> queryParaphrases(@Param("condition") String condition);

    List<ParaphraseNewlyAddedDO> queryParaphraseNewlyAdded();

    Long addParaphraseGroup(ParaphraseGroupDO pdo);

    Long addParaphraseInGroup(ParaphraseGroupDtlDO pdo);

    Long deleteParaphraseInGroup(@Param("groupId") Integer groupId, @Param("ParaphraseId") Integer ParaphraseId);

    List<ParaphraseDO> queryParaphrasesInGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
