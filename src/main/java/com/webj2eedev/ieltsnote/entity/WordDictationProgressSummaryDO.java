package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDictationProgressSummaryDO {
    private int id;
    private Integer parent_id;
    private String creator;
    private Timestamp createTime;
    private boolean complete;
    private Timestamp completeTime;
    private int validcnt;
    private Long progresscnt;
    private Long dontknowcount;
    private Long knowcount;
    private Long skipcount;
}
