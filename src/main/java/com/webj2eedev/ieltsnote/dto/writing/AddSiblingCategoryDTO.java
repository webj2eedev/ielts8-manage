package com.webj2eedev.ieltsnote.dto.writing;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddSiblingCategoryDTO {
    private Integer parentId;
    private String label;
    private Integer creator;
}
