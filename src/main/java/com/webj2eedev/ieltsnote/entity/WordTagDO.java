package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordTagDO {
    private int id;
    private String label;
    private String parent_id;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String comment;
}
