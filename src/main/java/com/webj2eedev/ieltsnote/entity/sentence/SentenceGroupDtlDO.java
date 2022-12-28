package com.webj2eedev.ieltsnote.entity.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class SentenceGroupDtlDO implements Serializable {
    private Integer uid;
    private Integer groupId;
    private Integer sentenceId;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
