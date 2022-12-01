package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TranslationSummaryDTO {
    private String practiceDay;
    private BigDecimal zhToEn;
    private BigDecimal enToZh;
}
