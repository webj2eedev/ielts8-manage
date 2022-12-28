package com.webj2eedev.ieltsnote.entity.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class SentenceDO implements Serializable {
    private Integer uid;
    private String content;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
