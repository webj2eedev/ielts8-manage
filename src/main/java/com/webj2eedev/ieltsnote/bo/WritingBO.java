package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WritingDao;
import com.webj2eedev.ieltsnote.dto.writing.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.writing.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.writing.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WritingBO {
    @Resource
    private WritingDao dao;

    public List<WritingCategoryDO> queryCatetory() {
        List<WritingCategoryDO> ret = dao.queryCatetory();
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

    public Long updateCategory(WritingCategoryDO pdto) {
        Long ret = dao.updateCategory(pdto);
        return ret;
    }

    public List<WritingSampleDO> querySamples(Integer categoryId) {
        List<WritingSampleDO> ret = dao.querySamples(categoryId);
        return ret;
    }

    public int addSample(WritingSampleDO pdo) {
        dao.addSample(pdo);

        WritingLogDO log = WritingLogDO.builder().part(2).categoryId(pdo.getCategoryId()).sampleId(pdo.getUid()).operation(WritingOperation.ADD).creator(pdo.getCreator()).build();
        dao.log(log);

        return pdo.getUid();
    }

    public Long updateSample(WritingSampleDO pDo) {
        Long ret = dao.updateSample(pDo);
        return ret;
    }

    public Long deleteSample(Integer uid) {
        Long ret = dao.deleteSample(uid);
        return ret;
    }

    public Long log(WritingLogDO pDo) {
        Long ret = dao.log(pDo);
        return ret;
    }

    public List<WritingNewlyAddedDO> queryWritingNewlyAdded(Integer creator) {
        List<WritingNewlyAddedDO> ret = dao.queryWritingNewlyAdded(creator);
        return ret;
    }

    public Long addSampleLink(WritingSampleLinkDO pdo) {
        Long ret = dao.addSampleLink(pdo);
        return ret;
    }

    public List<WritingSampleLinkDO> querySampleLinks(Integer sampleId) {
        List<WritingSampleLinkDO> ret = dao.querySampleLinks(sampleId);
        return ret;
    }
}
