package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReadingMaterialSummaryDO {
    private Long articleCnt;
    private String practiceDay;
}
