package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.WordTagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordTagDAO {

    List<WordTagDO> queryWordTags(@Param("wordTagDO") WordTagDO _do);

    boolean existWordTag(@Param("wordTagDO") WordTagDO _do);

    int addWordTag(WordTagDO _do);

    Long deleteWordTag(@Param("wordTagDO") WordTagDO _do);

    Long updateWordTag(@Param("wordTagDO") WordTagDO _do);
}
