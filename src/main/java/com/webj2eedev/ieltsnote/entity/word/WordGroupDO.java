package com.webj2eedev.ieltsnote.entity.word;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class WordGroupDO implements Serializable {
    private Integer uid;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
