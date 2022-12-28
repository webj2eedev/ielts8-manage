package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.SentenceDao;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceGroupDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceGroupDtlDO;
import com.webj2eedev.ieltsnote.entity.sentence.SentenceNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SentenceBO {
    @Resource
    private SentenceDao dao;
    @Autowired
    private MINIOClient minio;

    public int addSentence(String content, int creator) {
        SentenceDO pdo = SentenceDO.builder().content(content).creator(creator).build();

        dao.addSentence(pdo);

        return pdo.getUid();

    }

    public Long deleteSentence(Integer uid) {
        Long ret = dao.deleteSentence(uid);
        return ret;
    }

    public Long updateSentence(SentenceDO pdo) {
        Long ret = dao.updateSentence(pdo);
        return ret;
    }

    public SentenceDO querySentence(int uid) {
        return dao.querySentence(uid);
    }

    public List<SentenceDO> querySentences(String condition) {
        return dao.querySentences(condition);
    }

    public List<SentenceNewlyAddedDO> querySentenceNewlyAdded() {
        List<SentenceNewlyAddedDO> rDos = dao.querySentenceNewlyAdded();
        return rDos;
    }

    public int addSentenceGroup(String label, int creator) {
        SentenceGroupDO pdo = SentenceGroupDO.builder().label(label).creator(creator).build();
        dao.addSentenceGroup(pdo);
        return pdo.getUid();
    }

    public int addSentenceInGroup(int groupId, String sentence, int creator) {
        int sentenceId = this.addSentence(sentence, creator);

        SentenceGroupDtlDO pdo = SentenceGroupDtlDO.builder().groupId(groupId).sentenceId(sentenceId).creator(creator).build();
        dao.addSentenceInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteSentenceInGroup(int groupId, int wordId, boolean cascade) {
        if (cascade) {
            dao.deleteSentenceInGroup(groupId, wordId);
            return dao.deleteSentence(wordId);
        } else {
            return dao.deleteSentenceInGroup(groupId, wordId);
        }
    }

    public List<SentenceDO> querySentencesInGroup(int refId, String condition) {
        return dao.querySentencesInGroup(refId, condition);
    }

}