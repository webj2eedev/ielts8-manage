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
    private String word;
    private String libs;
    private String audioBritishOssid;
    private String audioAmericanOssid;
    private String tags;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String comment;

    public WordDO(String word){
        this(word, null, null, null, null, null, null, null, null);
    }
}
