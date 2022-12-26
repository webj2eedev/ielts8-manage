package com.webj2eedev.ieltsnote.entity.writing;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WritingLogDO {
    private Integer uid;
    private WritingOperation operation;
    private Integer part;
    private Integer categoryId;
    private Integer sampleId;
    private Integer creator;
    private Timestamp logTime;
}
