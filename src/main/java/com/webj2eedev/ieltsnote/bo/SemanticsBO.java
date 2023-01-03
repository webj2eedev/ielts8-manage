package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.SemanticsDao;
import com.webj2eedev.ieltsnote.dto.semantics.AddSemanticsExampleDTO;
import com.webj2eedev.ieltsnote.entity.semantics.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SemanticsBO {
    @Resource
    private SemanticsDao dao;
    @Autowired
    private MINIOClient minio;

    public int addSemantics(String type, String text, int creator) {
        SemanticsDO pdo = SemanticsDO.builder().type(type).text(text).creator(creator).build();

        dao.addSemantics(pdo);

        return pdo.getUid();

    }

    public Long deleteSemantics(Integer uid) {
        Long ret = dao.deleteSemantics(uid);
        return ret;
    }

    public Long updateSemantics(SemanticsDO pdo) {
        Long ret = dao.updateSemantics(pdo);
        return ret;
    }

    public SemanticsDO querySemantics(int uid) {
        return dao.querySemantics(uid);
    }

    public List<SemanticsDO> querySemanticss(String condition) {
        return dao.querySemanticss(condition);
    }

    public List<SemanticsNewlyAddedDO> querySemanticsNewlyAdded() {
        List<SemanticsNewlyAddedDO> rDos = dao.querySemanticsNewlyAdded();
        return rDos;
    }

    ////////////////////////////////////////////////////////////////

    public int addSemanticsExample(AddSemanticsExampleDTO pdto) {
        SemanticsExampleDO pdo = SemanticsExampleDO.builder()
                .semanticsId(pdto.getSemanticsId()).example(pdto.getExample()).comment(pdto.getComment()).creator(pdto.getCreator()).build();

        dao.addSemanticsExample(pdo);

        return pdo.getUid();
    }

    ////////////////////////////////////////////////////////////////
    public int addSemanticsGroup(int creator) {
        SemanticsGroupDO pdo = SemanticsGroupDO.builder().creator(creator).build();
        dao.addSemanticsGroup(pdo);
        return pdo.getUid();
    }

    public int addSemanticsInGroup(int groupId, String semanticsType, String semanticsText, int creator) {
        int id = this.addSemantics(semanticsType, semanticsText, creator);

        SemanticsGroupDtlDO pdo = SemanticsGroupDtlDO.builder().groupId(groupId).semanticsId(id).creator(creator).build();
        dao.addSemanticsInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteSemanticsInGroup(int groupId, int wordId, boolean cascade) {
        if (cascade) {
            dao.deleteSemanticsInGroup(groupId, wordId);
            return dao.deleteSemantics(wordId);
        } else {
            return dao.deleteSemanticsInGroup(groupId, wordId);
        }
    }

    public List<SemanticsDO> querySemanticssInGroup(int refId, String condition) {
        return dao.querySemanticssInGroup(refId, condition);
    }

}