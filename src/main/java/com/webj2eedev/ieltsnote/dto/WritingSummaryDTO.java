package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WritingSummaryDTO {
    private String practiceDay;
    private BigDecimal task1;
    private BigDecimal task2;
}
