package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.material.MaterialAttachmentDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialLogDO;
import com.webj2eedev.ieltsnote.entity.material.MaterialNewlyAddedDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialDao {
    int addMaterial(MaterialDO pDo);
    int deleteMaterial(@Param("uid") int uid);

    Long updateMaterial(MaterialDO pDo);

    List<MaterialDO> queryMaterials(@Param("condition") String condition);


    List<MaterialAttachmentDO> queryMaterialAttachments(MaterialDO pDo);

    int addMaterialAttachment(MaterialAttachmentDO pDo);
    Long updateMaterialAttachment(MaterialAttachmentDO pDo);

    Long log(MaterialLogDO pdo);
    List<MaterialNewlyAddedDO> summarizeMaterialNewlyAdded();
}
