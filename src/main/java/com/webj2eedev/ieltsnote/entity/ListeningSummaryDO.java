package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ListeningSummaryDO {
    private BigDecimal practiceDuration;
    private String practiceDay;
}
