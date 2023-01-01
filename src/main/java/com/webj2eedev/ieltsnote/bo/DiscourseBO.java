package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.DiscourseDao;
import com.webj2eedev.ieltsnote.dto.discourse.AddDiscourseExampleDTO;
import com.webj2eedev.ieltsnote.entity.discourse.*;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscourseBO {
    @Resource
    private DiscourseDao dao;
    @Autowired
    private MINIOClient minio;

    public int addDiscourse(String type, String text, int creator) {
        DiscourseDO pdo = DiscourseDO.builder().type(type).text(text).creator(creator).build();

        dao.addDiscourse(pdo);

        return pdo.getUid();

    }

    public Long deleteDiscourse(Integer uid) {
        Long ret = dao.deleteDiscourse(uid);
        return ret;
    }

    public Long updateDiscourse(DiscourseDO pdo) {
        Long ret = dao.updateDiscourse(pdo);
        return ret;
    }

    public DiscourseDO queryDiscourse(int uid) {
        return dao.queryDiscourse(uid);
    }

    public List<DiscourseDO> queryDiscourses(String condition) {
        return dao.queryDiscourses(condition);
    }

    public List<DiscourseNewlyAddedDO> queryDiscourseNewlyAdded() {
        List<DiscourseNewlyAddedDO> rDos = dao.queryDiscourseNewlyAdded();
        return rDos;
    }

    ////////////////////////////////////////////////////////////////

    public int addDiscourseExample(AddDiscourseExampleDTO pdto) {
        DiscourseExampleDO pdo = DiscourseExampleDO.builder()
                .discourseId(pdto.getDiscourseId()).example(pdto.getExample()).comment(pdto.getComment()).creator(pdto.getCreator()).build();

        dao.addDiscourseExample(pdo);

        return pdo.getUid();
    }

    ////////////////////////////////////////////////////////////////
    public int addDiscourseGroup(int creator) {
        DiscourseGroupDO pdo = DiscourseGroupDO.builder().creator(creator).build();
        dao.addDiscourseGroup(pdo);
        return pdo.getUid();
    }

    public int addDiscourseInGroup(int groupId, String discourseType, String discourseText, int creator) {
        int id = this.addDiscourse(discourseType, discourseText, creator);

        DiscourseGroupDtlDO pdo = DiscourseGroupDtlDO.builder().groupId(groupId).discourseId(id).creator(creator).build();
        dao.addDiscourseInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteDiscourseInGroup(int groupId, int wordId, boolean cascade) {
        if (cascade) {
            dao.deleteDiscourseInGroup(groupId, wordId);
            return dao.deleteDiscourse(wordId);
        } else {
            return dao.deleteDiscourseInGroup(groupId, wordId);
        }
    }

    public List<DiscourseDO> queryDiscoursesInGroup(int refId, String condition) {
        return dao.queryDiscoursesInGroup(refId, condition);
    }

}