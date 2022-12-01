package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDictationProgressDTO {
    private int uid;
    private int id;
    private String word;
    private int progress;
    private int action;
    private Timestamp createTime;
}
