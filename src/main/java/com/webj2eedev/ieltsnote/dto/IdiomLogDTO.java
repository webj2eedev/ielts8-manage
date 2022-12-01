package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class IdiomLogDTO {
    private Integer uid;
    private String action;
    private Integer categoryId;
    private String categoryLabel;
    private Integer expressionId;
    private String expressionText;
    private Integer sampleId;
    private String sampleText;
    private String creator;
    private Timestamp logTime;
}
