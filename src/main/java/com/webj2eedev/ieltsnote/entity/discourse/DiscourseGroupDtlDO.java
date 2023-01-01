package com.webj2eedev.ieltsnote.entity.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class DiscourseGroupDtlDO implements Serializable {
    private Integer uid;
    private Integer groupId;
    private Integer discourseId;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
