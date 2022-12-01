package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IdiomSummaryDTO {
    private Long idiomCnt;
    private String practiceDay;
}
