package com.webj2eedev.ieltsnote.entity.writing;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WritingLogDO {
    public static enum Operation {
        ADD,
        DELETE,
        UPDATE,
        QUERY,
    }

    private Integer uid;
    private Operation operation;
    private Integer part;
    private Integer categoryId;
    private Integer sampleId;
    private Integer creator;
    private Timestamp logTime;
}
