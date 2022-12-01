package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WritingSummaryDO {
    private String practiceDay;
    private BigDecimal task1;
    private BigDecimal task2;
}
