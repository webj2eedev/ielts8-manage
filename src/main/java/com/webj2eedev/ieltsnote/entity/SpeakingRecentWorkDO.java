package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class SpeakingRecentWorkDO {
    private Integer part;
    private String category;
    private String question;
    private Timestamp createTime;
}
