package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddGrammarMaterialDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarCategoryDO;
import com.webj2eedev.ieltsnote.entity.grammar.GrammarMaterialDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrammarDao {
    List<GrammarCategoryDO> queryCatetory();

    Long addSiblingCategory(AddSiblingCategoryDTO pdto);

    Long addChildCategory(AddChildCategoryDTO pdto);

    Long updateCategory(GrammarCategoryDO pDo);

    ///////////////////////////////////////////////////

    Long addGrammarMaterial(AddGrammarMaterialDTO pDo);

    List<GrammarMaterialDO> queryGrammarMaterialList(@Param("categoryId") Integer categoryId);

    Long deleteGrammarMaterial(@Param("uid") int uid);
}
