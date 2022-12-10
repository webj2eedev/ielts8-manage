package com.webj2eedev.ieltsnote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class WordDO implements Serializable {
    private Integer uid;
    private String word;
    private String phoneticBritish;
    private String phoneticAmerican;
    private String speechBritishOssid;
    private String speechAmericanOssid;
    private Boolean mindSpelling;
    private Boolean mindPronunciation;
    private Boolean mindStressPosition;
    private Boolean mindWordClasses;
    private Integer stars;
    private Integer addCount;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
