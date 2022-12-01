package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordDictationSessionDTO {
    private int id;
    private Integer parentId;
    private String creator;
    private Timestamp createTime;
    private boolean complete;
    private Timestamp completeTime;
    private int wordNums;
    private String wordList;

    private int pagenum;
    private int pagesize;
}
