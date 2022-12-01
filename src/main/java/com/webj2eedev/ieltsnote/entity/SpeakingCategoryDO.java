package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpeakingCategoryDO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String label;
    private String comment;
    private Integer storylineCategoryId;
    private String tags;
}
