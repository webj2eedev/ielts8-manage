package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface StorylineDAO {
    List<StorylineCategoryDO> queryCatetory(StorylineCategoryDO pDo);

    Long addSiblingCategory(StorylineCategoryDO pDo);

    Long addChildCategory(StorylineCategoryDO pDo);

    StorylineCategoryDO queryCategoryById(StorylineCategoryDO pDo);

    Long updateCategory(StorylineCategoryDO pDo);
}
