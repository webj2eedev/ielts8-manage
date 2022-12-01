package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CCSummaryDO {
    private Long questionCnt;
    private String practiceDay;
}
