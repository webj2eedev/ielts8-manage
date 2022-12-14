package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.MaterialDao;
import com.webj2eedev.ieltsnote.entity.material.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialBO {
    @Resource
    private MaterialDao dao;

    public int addMaterial(MaterialDO pdo) {
        dao.addMaterial(pdo);

        return pdo.getUid();
    }

    public Long deleteMaterial(int uid) {
        return dao.deleteMaterial(uid);
    }

    public Long updateMaterial(MaterialDO pdo) {
        Long ret = dao.updateMaterial(pdo);
        return ret;
    }

    public MaterialDO queryMaterial(int uid) {
        return dao.queryMaterial(uid);
    }

    public List<MaterialDO> queryMaterials(String condition) {
        return dao.queryMaterials(condition);
    }

    ////////////////////////////////////////////////////////////////

    public int addMaterialAttachment(MaterialAttachmentDO pdo) {
        dao.addMaterialAttachment(pdo);
        return pdo.getUid();
    }

    public int deleteMaterialAttachment(int uid) {
        return dao.deleteMaterialAttachment(uid);
    }


    public Long updateMaterialAttachment(MaterialAttachmentDO pdo) {
        Long ret = dao.updateMaterialAttachment(pdo);
        return ret;
    }

    public MaterialAttachmentDO queryMaterialAttachment(int uid) {
        return dao.queryMaterialAttachment(uid);
    }

    public List<MaterialAttachmentDO> queryMaterialAttachments(int materialId) {
        return dao.queryMaterialAttachments(materialId);
    }

    ////////////////////////////////////////////////////////////////

    public List<MaterialNewlyAddedDO> queryMaterialNewlyAdded() {
        List<MaterialNewlyAddedDO> ret = dao.queryMaterialNewlyAdded();
        return ret;
    }

    ////////////////////////////////////////////////////////////////
    public int addMaterialGroup(int creator) {
        MaterialGroupDO pdo = MaterialGroupDO.builder().creator(creator).build();
        dao.addMaterialGroup(pdo);
        return pdo.getUid();
    }

    public int addMaterialInGroup(int groupId, int materialId, int creator) {
        MaterialGroupDtlDO pdo = MaterialGroupDtlDO.builder().groupId(groupId).materialId(materialId).creator(creator).build();
        dao.addMaterialInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteMaterialInGroup(int groupId, int materialId) {
        dao.deleteMaterialInGroup(groupId, materialId);
        return dao.deleteMaterial(materialId);
    }

    public List<MaterialDO> queryMaterialListInGroup(int refId) {
        return dao.queryMaterialListInGroup(refId);
    }
}
