package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.discourse.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscourseDao {
    void addDiscourse(DiscourseDO pdo);

    Long deleteDiscourse(@Param("uid") Integer uid);

    Long updateDiscourse(DiscourseDO pdo);

    DiscourseDO queryDiscourse(@Param("uid") int uid);

    List<DiscourseDO> queryDiscourses(@Param("condition") String condition);

    List<DiscourseNewlyAddedDO> queryDiscourseNewlyAdded();

    //////////////////////////////////////////////////

    void addDiscourseExample(DiscourseExampleDO pdo);

    //////////////////////////////////////////////////

    Long addDiscourseGroup(DiscourseGroupDO pdo);

    Long addDiscourseInGroup(DiscourseGroupDtlDO pdo);

    Long deleteDiscourseInGroup(@Param("groupId") Integer groupId, @Param("discourseId") Integer discourseId);

    List<DiscourseDO> queryDiscoursesInGroup(@Param("groupId") int groupId, @Param("condition") String condition);
}
