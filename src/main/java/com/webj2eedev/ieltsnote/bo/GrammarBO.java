package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.GrammarDao;
import com.webj2eedev.ieltsnote.dao.MaterialDao;
import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddGrammarMaterialDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.DeleteGrammarMaterialDTO;
import com.webj2eedev.ieltsnote.entity.grammar.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GrammarBO {
    @Resource
    private GrammarDao dao;
    @Resource
    private MaterialDao materialDao;

    public List<GrammarCategoryDO> queryCategory() {
        List<GrammarCategoryDO> ret = dao.queryCategory();
        return ret;
    }

    public List<GrammarCategoryDO> queryLeafCategory() {
        List<GrammarCategoryDO> ret = dao.queryLeafCategory();
        return ret;
    }

    public Long addSiblingCategory(AddSiblingCategoryDTO pdto) {
        Long ret = dao.addSiblingCategory(pdto);
        return ret;
    }

    public Long addChildCategory(AddChildCategoryDTO pdto) {
        Long ret = dao.addChildCategory(pdto);
        return ret;
    }

    public Long updateCategory(GrammarCategoryDO pdto) {
        Long ret = dao.updateCategory(pdto);
        return ret;
    }

    ////////////////////////////////////////////////////////////

    public List<GrammarNewlyAddedDO> queryGrammarNewlyAdded() {
        List<GrammarNewlyAddedDO> rDos = dao.queryGrammarNewlyAdded();
        return rDos;
    }

    ////////////////////////////////////////////////////////////////

    public Integer addGrammarMaterial(AddGrammarMaterialDTO pdto) {
        dao.addGrammarMaterial(pdto);
        return pdto.getUid();
    }

    public List<GrammarMaterialDO> queryGrammarMaterialList(Integer categoryId) {
        List<GrammarMaterialDO> ret = dao.queryGrammarMaterialList(categoryId);
        return ret;
    }

    public Long deleteGrammarMaterial(DeleteGrammarMaterialDTO pdto) {
        Long ret1 = dao.deleteGrammarMaterial(pdto.getUid());
        Long ret2 = materialDao.deleteMaterial(pdto.getMaterialId());
        return ret1 + ret2;
    }

    ////////////////////////////////////////////////////////////////


    public int addGrammarSentenceGroup(int creator) {
        GrammarSentenceGroupDO pdo = GrammarSentenceGroupDO.builder().creator(creator).build();
        dao.addGrammarSentenceGroup(pdo);
        return pdo.getUid();
    }

    public int addGrammarSentenceInGroup(int groupId, int grammarCategoryId, int grammarSentenceId, int creator) {
        GrammarSentenceGroupDtlDO pdo = GrammarSentenceGroupDtlDO.builder().groupId(groupId).grammarCategoryId(grammarCategoryId).grammarSentenceId(grammarSentenceId).creator(creator).build();
        dao.addGrammarSentenceInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteGrammarSentenceInGroup(int uid) {
        return dao.deleteGrammarSentenceInGroup(uid);

    }

    public List<GrammarSentenceDO> queryGrammarSentenceListInGroup(int groupId) {
        return dao.queryGrammarSentenceListInGroup(groupId);
    }

}
