package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class SpeakingAnswerMp3DO {
    private Integer mp3Id;
    private Integer answerId;
    private String answerMp3Ossid;
    private Integer answerMp3Duration;
    private String answerVideoOssid;
    private String answerVideoPosterOssid;
    private String answerVideoSubtitleOssid;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
