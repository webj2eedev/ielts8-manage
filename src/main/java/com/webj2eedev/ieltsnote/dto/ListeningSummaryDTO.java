package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ListeningSummaryDTO {
    private BigDecimal practiceDuration;
    private String practiceDay;
}
