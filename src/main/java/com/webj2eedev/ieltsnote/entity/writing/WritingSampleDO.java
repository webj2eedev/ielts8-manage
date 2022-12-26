package com.webj2eedev.ieltsnote.entity.writing;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WritingSampleDO {
    private Integer uid;
    private Integer categoryId;
    private String title;
    private String content;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
