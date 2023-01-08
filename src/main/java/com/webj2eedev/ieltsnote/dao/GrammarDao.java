package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarCategoryDO;

import java.util.List;

public interface GrammarDao {
    List<GrammarCategoryDO> queryCatetory();

    Long addSiblingCategory(AddSiblingCategoryDTO pdto);

    Long addChildCategory(AddChildCategoryDTO pdto);

    Long updateCategory(GrammarCategoryDO pDo);
}
