package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ListeningLogDO {
    private Integer uid;
    private String action;
    private Integer categoryId;
    private String categoryLabel;
    private Integer sceneId;
    private String sceneLabel;
    private Integer mp3Id;
    private Integer mp3Duration;
    private Integer listeningDuration;
    private String creator;
    private Timestamp logTime;
}
