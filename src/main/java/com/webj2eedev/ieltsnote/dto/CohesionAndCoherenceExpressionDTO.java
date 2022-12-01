package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class CohesionAndCoherenceExpressionDTO {
    private int category;
    private int expressionId;
    private String expressionZh;
    private String expressionEn;
    private String expressionConnectType;
    private String expressionComment;
    private String expressionCreator;
    private Timestamp expressionCreateTime;
    private Timestamp expressionUpdateTime;
    private Integer sampleId;
    private String sampleZh;
    private String sampleEn;
    private String sampleComment;
    private String sampleCreator;
    private Timestamp sampleCreateTime;
    private Timestamp sampleUpdateTime;
}
