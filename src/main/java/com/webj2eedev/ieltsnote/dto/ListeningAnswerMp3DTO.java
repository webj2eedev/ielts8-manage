package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ListeningAnswerMp3DTO {
    private Integer mp3Id;
    private Integer answerId;
    private String answerMp3Ossid;
    private Integer answerMp3Duration;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
