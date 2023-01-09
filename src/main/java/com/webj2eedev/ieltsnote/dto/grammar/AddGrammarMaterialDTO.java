package com.webj2eedev.ieltsnote.dto.grammar;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddGrammarMaterialDTO {
    private Integer uid;
    private Integer categoryId;
    private Integer materialId;
    private String comment;
    private Integer creator;
}
