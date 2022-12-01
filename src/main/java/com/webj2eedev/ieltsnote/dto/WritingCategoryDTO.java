package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WritingCategoryDTO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String labelZh;
    private String labelEn;
    private String comment;
    private Integer storylineCategoryId;
}
