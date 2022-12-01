package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDictationProgressSummaryDTO {
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
