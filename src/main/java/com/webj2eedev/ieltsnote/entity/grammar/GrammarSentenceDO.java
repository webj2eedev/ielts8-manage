package com.webj2eedev.ieltsnote.entity.grammar;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class GrammarSentenceDO implements Serializable {
    private Integer uid;
    private Integer groupId;
    private Integer grammarCategoryId;
    private String grammarCategoryLabel;
    private Integer grammarSentenceId;
    private String grammarSentenceContent;
    private String grammarSentenceComment;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
