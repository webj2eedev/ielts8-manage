package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class WordlistRefWordDO implements Serializable {
    private Integer uid;
    private Integer refId;
    private Integer wordId;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
