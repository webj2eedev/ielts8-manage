package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class SpeakingLogDO {
    private Integer uid;
    private String action;
    private Integer part;
    private Integer categoryId;
    private String categoryLabel;
    private Integer questionId;
    private String questionText;
    private Integer answerId;
    private String answerText;
    private Integer mp3Id;
    private Integer mp3Duration;
    private String creator;
    private Timestamp logTime;
}
