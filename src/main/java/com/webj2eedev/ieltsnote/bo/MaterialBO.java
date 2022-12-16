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

        MaterialLogDO log = MaterialLogDO.builder().materialId(pdo.getUid()).operation(MaterialOperation.ADD).creator(pdo.getCreator()).build();
        dao.log(log);

        return pdo.getUid();
    }

    public int deleteMaterial(int uid) {
        return dao.deleteMaterial(uid);
    }

    public Long updateMaterial(MaterialDO pdo) {
        Long ret = dao.updateMaterial(pdo);
        return ret;
    }

    public List<MaterialDO> queryMaterials(String condition) {
        return dao.queryMaterials(condition);
    }


    public int addMaterialAttachment(MaterialAttachmentDO pdo) {
        dao.addMaterialAttachment(pdo);
        return pdo.getUid();
    }

    public Long updateMaterialAttachment(MaterialAttachmentDO pdo) {
        Long ret = dao.updateMaterialAttachment(pdo);
        return ret;
    }

    public Long log(MaterialLogDO pdo) {
        Long ret = dao.log(pdo);
        return ret;
    }

    public List<MaterialNewlyAddedDO> summarizeMaterialNewlyAdded() {
        List<MaterialNewlyAddedDO> ret = dao.summarizeMaterialNewlyAdded();
        return ret;
    }
}
