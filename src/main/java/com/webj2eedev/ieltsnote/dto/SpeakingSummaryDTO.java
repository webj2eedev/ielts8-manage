package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class SpeakingSummaryDTO {
    private String practiceDay;
    private BigDecimal part1;
    private BigDecimal part2;
    private BigDecimal part3;
}
