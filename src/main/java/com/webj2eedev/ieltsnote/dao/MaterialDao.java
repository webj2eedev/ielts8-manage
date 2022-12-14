package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.material.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialDao {
    int addMaterial(MaterialDO pDo);
    Long deleteMaterial(@Param("uid") int uid);

    Long updateMaterial(MaterialDO pDo);

    MaterialDO queryMaterial(@Param("uid") int uid);

    List<MaterialDO> queryMaterials(@Param("condition") String condition);

    int addMaterialAttachment(MaterialAttachmentDO pDo);

    int deleteMaterialAttachment(@Param("uid") int uid);

    Long updateMaterialAttachment(MaterialAttachmentDO pDo);
    MaterialAttachmentDO queryMaterialAttachment(@Param("uid") int uid);

    List<MaterialAttachmentDO> queryMaterialAttachments(@Param("materialId") int materialId);

    //////////////////////////////////////////////////

    List<MaterialNewlyAddedDO> queryMaterialNewlyAdded();

    //////////////////////////////////////////////////

    Long addMaterialGroup(MaterialGroupDO pdo);

    Long addMaterialInGroup(MaterialGroupDtlDO pdo);

    Long deleteMaterialInGroup(@Param("groupId") Integer groupId, @Param("materialId") Integer materialId);

    List<MaterialDO> queryMaterialListInGroup(@Param("groupId") int groupId);
}
