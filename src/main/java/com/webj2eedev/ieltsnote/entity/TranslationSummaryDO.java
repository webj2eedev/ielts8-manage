package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TranslationSummaryDO {
    private String practiceDay;
    private BigDecimal zhToEn;
    private BigDecimal enToZh;
}
