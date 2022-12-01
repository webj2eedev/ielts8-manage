package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ListeningQADTO {
    private Integer part;
    private Integer category;
    private Integer questionId;
    private String question;
    private String questionCreator;
    private Timestamp questionCreateTime;
    private Integer answerId;
    private String answerThought;
    private String answerText;
    private Long answerMp3Cnt;
    private String answerCohesionAndCoherenceTags;
    private String answerComment;
    private String answerCreator;
    private Timestamp answerCreateTime;
    private Timestamp answerUpdateTime;
}
