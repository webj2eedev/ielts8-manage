package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDTO {
    private String word;
    private String libs;
    private String audioBritishOssid;
    private String audioAmericanOssid;
    private String tags;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String comment;

    private int pagenum;
    private int pagesize;
}
