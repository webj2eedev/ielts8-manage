package com.webj2eedev.ieltsnote.entity.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class DiscourseDO implements Serializable {
    private Integer uid;
    private String type;
    private String text;
    private String example;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
