package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class SynonymsSubstitutionArticleDO {
    private int id;
    private int category;
    private String leftValue;
    private String rightValue;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
