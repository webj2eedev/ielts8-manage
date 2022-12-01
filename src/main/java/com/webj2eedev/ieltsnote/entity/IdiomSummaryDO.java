package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IdiomSummaryDO {
    private Long idiomCnt;
    private String practiceDay;
}
