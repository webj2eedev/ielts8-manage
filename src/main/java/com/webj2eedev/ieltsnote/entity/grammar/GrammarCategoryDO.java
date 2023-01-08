package com.webj2eedev.ieltsnote.entity.grammar;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class GrammarCategoryDO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String label;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
