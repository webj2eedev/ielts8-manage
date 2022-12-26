package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.dto.writing.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.writing.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.writing.WritingCategoryDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingLogDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingSampleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WritingDao {
    List<WritingCategoryDO> queryCatetory();

    Long addSiblingCategory(AddSiblingCategoryDTO pdto);

    Long addChildCategory(AddChildCategoryDTO pdto);

    Long updateCategory(WritingCategoryDO pDo);

    List<WritingSampleDO> querySamples(@Param("categoryId") Integer categoryId);

    Long addSample(WritingSampleDO pDo);

    Long updateSample(WritingSampleDO pDo);

    Long deleteSample(@Param("uid") Integer uid);

    Long log(WritingLogDO pDo);

    List<WritingNewlyAddedDO> queryWritingNewlyAdded(@Param("creator") Integer creator);
}
