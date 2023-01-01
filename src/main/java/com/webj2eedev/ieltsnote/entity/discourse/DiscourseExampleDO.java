package com.webj2eedev.ieltsnote.entity.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class DiscourseExampleDO implements Serializable {
    private Integer uid;
    private Integer discourseId;
    private String example;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
