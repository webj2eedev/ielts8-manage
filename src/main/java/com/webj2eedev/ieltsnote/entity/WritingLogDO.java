package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WritingLogDO {
    private Integer uid;
    private String action;
    private Integer part;
    private Integer categoryId;
    private String categoryLabel;
    private Integer expressionId;
    private String expressionText;
    private Integer sampleId;
    private String sampleText;
    private String creator;
    private Timestamp logTime;
}
