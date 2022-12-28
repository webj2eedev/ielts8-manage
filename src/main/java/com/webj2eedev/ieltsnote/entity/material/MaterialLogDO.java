package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class MaterialLogDO {
    public static enum Operation {
        ADD,
        DELETE,
        UPDATE,
        QUERY,
    }
    private Integer uid;
    private Integer materialId;
    private Operation operation;
    private Integer creator;
    private Timestamp logTime;
}
