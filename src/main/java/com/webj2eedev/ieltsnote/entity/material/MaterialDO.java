package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class MaterialDO {
    private int uid;
    private String content;
    private String comment;
    private Integer creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
