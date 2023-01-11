package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddGrammarMaterialDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.grammar.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrammarDao {
    List<GrammarCategoryDO> queryCategory();

    List<GrammarCategoryDO> queryLeafCategory();


    Long addSiblingCategory(AddSiblingCategoryDTO pdto);

    Long addChildCategory(AddChildCategoryDTO pdto);

    Long updateCategory(GrammarCategoryDO pDo);

    ///////////////////////////////////////////////////
    List<GrammarNewlyAddedDO> queryGrammarNewlyAdded();

    //////////////////////////////////////////////////
    Long addGrammarMaterial(AddGrammarMaterialDTO pDo);

    List<GrammarMaterialDO> queryGrammarMaterialList(@Param("categoryId") Integer categoryId);

    Long deleteGrammarMaterial(@Param("uid") int uid);

    ///////////////////////////////////////////////////

    Long addGrammarSentenceGroup(GrammarSentenceGroupDO pdo);

    Long addGrammarSentenceInGroup(GrammarSentenceGroupDtlDO pdo);

    Long deleteGrammarSentenceInGroup(@Param("uid") Integer uid);

    List<GrammarSentenceDO> queryGrammarSentenceListInGroup(@Param("groupId") int groupId);

    ///////////////////////////////////////////////////
}
