package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class DiyMaterialAttachmentDO {
    private int uid;
    private int materialId;
    private int type;
    private String externalUrl;
    private String embeddedCode;
    private String fileName;
    private String fileContentType;
    private String fileOssid;
    private String comment;
    private String creator;
    private Timestamp createTime;
    private Timestamp updateTime;
}
