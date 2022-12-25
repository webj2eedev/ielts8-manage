package com.webj2eedev.ieltsnote.entity.word;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WordNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
