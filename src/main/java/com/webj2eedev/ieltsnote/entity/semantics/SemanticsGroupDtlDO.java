package com.webj2eedev.ieltsnote.entity.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class SemanticsGroupDtlDO implements Serializable {
    private Integer uid;
    private Integer groupId;
    private Integer semanticsId;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
