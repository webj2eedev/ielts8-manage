package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class MaterialAttachmentDO {
    private int uid;
    private int materialId;
    private String attachment;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
