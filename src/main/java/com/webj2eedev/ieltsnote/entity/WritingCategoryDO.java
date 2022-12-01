package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WritingCategoryDO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String labelZh;
    private String labelEn;
    private String comment;
    private Integer storylineCategoryId;
}
