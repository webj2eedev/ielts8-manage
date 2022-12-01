package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReadingTestCategoryDTO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String label;
    private String comment;
    private Integer storylineCategoryId;
}
