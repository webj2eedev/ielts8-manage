package com.webj2eedev.ieltsnote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
public class WordDO implements Serializable {
    private Integer uid;
    private String word;
    private String phoneticBritish;
    private String phoneticAmerican;
    private String speechBritishOssid;
    private String speechAmericanOssid;
    private Boolean mindPronunciation;
    private Boolean mindStressPosition;
    private Integer addCount;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
