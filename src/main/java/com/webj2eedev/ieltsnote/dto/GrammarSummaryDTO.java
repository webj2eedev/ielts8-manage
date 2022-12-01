package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GrammarSummaryDTO {
    private Long articleCnt;
    private String practiceDay;
}
