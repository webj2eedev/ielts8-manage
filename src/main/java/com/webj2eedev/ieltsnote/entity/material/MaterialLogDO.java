package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class MaterialLogDO {
    private Integer uid;
    private Integer materialId;
    private MaterialOperation operation;
    private Integer creator;
    private Timestamp logTime;
}
