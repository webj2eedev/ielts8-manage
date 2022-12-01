package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class GrammarArticleDO {
    private int id;
    private int category;
    private String title;
    private String content;
    private String embeddedResource;
    private String externalLink;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
