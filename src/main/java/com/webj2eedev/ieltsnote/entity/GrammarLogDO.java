package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class GrammarLogDO {
    private Integer uid;
    private String action;
    private Integer categoryId;
    private String categoryLabel;
    private Integer articleId;
    private String articleTitle;
    private String creator;
    private Timestamp logTime;
}
