package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CollocationSummaryDTO {
    private Long questionCnt;
    private String practiceDay;
}
