package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class DiyMaterialDO {
    private int id;
    private int category;
    private String title;
    private String content;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
