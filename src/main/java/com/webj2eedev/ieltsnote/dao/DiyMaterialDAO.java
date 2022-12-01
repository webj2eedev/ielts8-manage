package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.*;

import java.util.List;

public interface DiyMaterialDAO {
    List<DiyMaterialCategoryDO> queryCatetory(DiyMaterialCategoryDO pDo);

    int addSiblingCategory(DiyMaterialCategoryDO pDo);

    int addChildCategory(DiyMaterialCategoryDO pDo);

    List<DiyMaterialDO> queryDiyMaterials(DiyMaterialCategoryDO pDo);

    int addDiyMaterial(DiyMaterialDO pDo);
    int deleteDiyMaterial(DiyMaterialDO pDo);

    Long updateDiyMaterial(DiyMaterialDO pDo);

    List<DiyMaterialAttachmentDO> queryDiyMaterialAttachments(DiyMaterialDO pDo);

    int addDiyMaterialAttachment(DiyMaterialAttachmentDO pDo);
    Long updateDiyMaterialAttachment(DiyMaterialAttachmentDO pDo);

    Long log(DiyMaterialLogDO pDo);
    List<DiyMaterialSummaryDO> queryLogSummary(DiyMaterialLogDO pDo);

}
