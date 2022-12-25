package com.webj2eedev.ieltsnote.dto.writing;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddChildCategoryDTO {
    private Integer id;
    private String label;
    private Integer creator;
}
