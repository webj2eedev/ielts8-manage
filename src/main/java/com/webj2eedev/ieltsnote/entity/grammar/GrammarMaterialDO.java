package com.webj2eedev.ieltsnote.entity.grammar;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class GrammarMaterialDO {
    private Integer uid;
    private Integer categoryId;
    private Integer materialId;
    private String materialContentCut;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
