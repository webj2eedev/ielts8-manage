package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.semantics.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SemanticsDao {
    void addSemantics(SemanticsDO pdo);

    Long deleteSemantics(@Param("uid") Integer uid);

    Long updateSemantics(SemanticsDO pdo);

    SemanticsDO querySemantics(@Param("uid") int uid);

    List<SemanticsDO> querySemanticss(@Param("condition") String condition);

    List<SemanticsNewlyAddedDO> querySemanticsNewlyAdded();

    //////////////////////////////////////////////////

    void addSemanticsExample(SemanticsExampleDO pdo);

    //////////////////////////////////////////////////

    Long addSemanticsGroup(SemanticsGroupDO pdo);

    Long addSemanticsInGroup(SemanticsGroupDtlDO pdo);

    Long deleteSemanticsInGroup(@Param("groupId") Integer groupId, @Param("semanticsId") Integer semanticsId);

    List<SemanticsDO> querySemanticssInGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
