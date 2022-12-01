package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class TranslationLogDTO {
    private Integer uid;
    private String action;
    private Integer part;
    private Integer categoryId;
    private String categoryLabel;
    private Integer questionId;
    private String questionText;
    private String creator;
    private Timestamp logTime;
}
