package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.DiyMaterialDAO;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiyMaterialBO {
    @Resource
    private DiyMaterialDAO dao;

    public List<DiyMaterialCategoryDO> queryCatetory(DiyMaterialCategoryDO pDo) {
        List<DiyMaterialCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos;
    }

    public int addSiblingCategory(DiyMaterialCategoryDO pDo) {
        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public int addChildCategory(DiyMaterialCategoryDO pDo) {
        dao.addChildCategory(pDo);
        return pDo.getId();
    }

    public List<DiyMaterialDO> queryDiyMaterials(DiyMaterialCategoryDO pDo) {
        List<DiyMaterialDO> rDos = dao.queryDiyMaterials(pDo);
        return rDos;
    }
    public int addDiyMaterial(DiyMaterialDO pDo) {
        dao.addDiyMaterial(pDo);
        return pDo.getId();
    }

    public int deleteDiyMaterial(DiyMaterialDO pDo) {
        return dao.deleteDiyMaterial(pDo);
    }

    public Long updateDiyMaterial(DiyMaterialDO pDo) {
        Long ret = dao.updateDiyMaterial(pDo);
        return ret;
    }

    public List<DiyMaterialAttachmentDO> queryDiyMaterialAttachments(DiyMaterialDO pDo) {
        List<DiyMaterialAttachmentDO> rDos = dao.queryDiyMaterialAttachments(pDo);
        return rDos;
    }

    public int addDiyMaterialAttachment(DiyMaterialAttachmentDO pDo) {
        dao.addDiyMaterialAttachment(pDo);
        return pDo.getUid();
    }

    public Long updateDiyMaterialAttachment(DiyMaterialAttachmentDO pDo) {
        Long ret = dao.updateDiyMaterialAttachment(pDo);
        return ret;
    }

    public Long log(DiyMaterialLogDO pDo) {
        Long ret = dao.log(pDo);
        return ret;
    }
    public List<DiyMaterialSummaryDO> queryLogSummary(DiyMaterialLogDO pDo) {
        List<DiyMaterialSummaryDO> rDos = dao.queryLogSummary(pDo);
        return rDos;
    }
}
