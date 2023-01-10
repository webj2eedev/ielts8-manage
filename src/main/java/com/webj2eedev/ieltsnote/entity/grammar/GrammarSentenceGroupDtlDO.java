package com.webj2eedev.ieltsnote.entity.grammar;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class GrammarSentenceGroupDtlDO implements Serializable {
    private Integer uid;
    private Integer groupId;
    private Integer grammarCategoryId;
    private Integer grammarSentenceId;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
