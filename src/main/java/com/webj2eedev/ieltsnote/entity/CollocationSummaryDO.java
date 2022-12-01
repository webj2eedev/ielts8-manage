package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CollocationSummaryDO {
    private Long questionCnt;
    private String practiceDay;
}
