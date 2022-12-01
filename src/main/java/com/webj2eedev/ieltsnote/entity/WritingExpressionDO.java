package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Data
public class WritingExpressionDO {
    private int part;
    private int category;
    private int expressionId;
    private String expressionTitle;
    private String expressionStem;
    private String expressionComment;
    private String expressionCreator;
    private Timestamp expressionCreateTime;
    private Timestamp expressionUpdateTime;
    private Integer sampleId;
    private String sampleDraft;
    private BigDecimal sampleOverallBandScore;
    private String sampleDraftAnalyzer;
    private String sampleComment;
    private String sampleCreator;
    private Timestamp sampleCreateTime;
    private Timestamp sampleUpdateTime;
}
