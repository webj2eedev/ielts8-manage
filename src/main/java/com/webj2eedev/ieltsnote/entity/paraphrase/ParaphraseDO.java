package com.webj2eedev.ieltsnote.entity.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class ParaphraseDO implements Serializable {
    private Integer uid;
    private String text;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
