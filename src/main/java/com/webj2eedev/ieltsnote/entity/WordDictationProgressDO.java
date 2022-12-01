package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDictationProgressDO {
    private int uid;
    private int id;
    private String word;
    private int progress;
    private int action;
    private Timestamp createTime;
}
