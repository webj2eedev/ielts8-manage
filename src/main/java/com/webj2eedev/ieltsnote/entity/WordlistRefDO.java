package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class WordlistRefDO implements Serializable {
    private Integer uid;
    private String label;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
