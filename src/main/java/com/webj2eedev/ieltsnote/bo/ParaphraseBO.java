package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.ParaphraseDao;
import com.webj2eedev.ieltsnote.dto.paraphrase.AddParaphraseRewriteDTO;
import com.webj2eedev.ieltsnote.entity.paraphrase.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParaphraseBO {
    @Resource
    private ParaphraseDao dao;
    @Autowired
    private MINIOClient minio;

    public int addParaphrase(String text, int creator) {
        ParaphraseDO pdo = ParaphraseDO.builder().text(text).creator(creator).build();

        dao.addParaphrase(pdo);

        return pdo.getUid();
    }

    public Long deleteParaphrase(Integer uid) {
        Long ret = dao.deleteParaphrase(uid);
        return ret;
    }

    public Long updateParaphrase(ParaphraseDO pdo) {
        Long ret = dao.updateParaphrase(pdo);
        return ret;
    }

    public List<ParaphraseDO> queryParaphrases(String condition) {
        return dao.queryParaphrases(condition);
    }

    public List<ParaphraseNewlyAddedDO> queryParaphraseNewlyAdded() {
        List<ParaphraseNewlyAddedDO> rDos = dao.queryParaphraseNewlyAdded();
        return rDos;
    }

    //////////////////////////////////////////////////

    public int addParaphraseRewrite(AddParaphraseRewriteDTO pdto) {
        ParaphraseRewriteDO pdo = ParaphraseRewriteDO.builder()
                .paraphraseId(pdto.getParaphraseId()).rewrite(pdto.getRewrite()).comment(pdto.getComment()).creator(pdto.getCreator()).build();

        dao.addParaphraseRewrite(pdo);

        return pdo.getUid();

    }


    //////////////////////////////////////////////////

    public int addParaphraseGroup(int creator) {
        ParaphraseGroupDO pdo = ParaphraseGroupDO.builder().creator(creator).build();
        dao.addParaphraseGroup(pdo);
        return pdo.getUid();
    }

    public int addParaphraseInGroup(int groupId, String sentence, int creator) {
        int paraphraseId = this.addParaphrase(sentence, creator);

        ParaphraseGroupDtlDO pdo = ParaphraseGroupDtlDO.builder().groupId(groupId).paraphraseId(paraphraseId).creator(creator).build();
        dao.addParaphraseInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteParaphraseInGroup(int groupId, int wordId, boolean cascade) {
        if (cascade) {
            dao.deleteParaphraseInGroup(groupId, wordId);
            return dao.deleteParaphrase(wordId);
        } else {
            return dao.deleteParaphraseInGroup(groupId, wordId);
        }
    }

    public List<ParaphraseDO> queryParaphrasesInGroup(int refId, String condition) {
        return dao.queryParaphrasesInGroup(refId, condition);
    }

}