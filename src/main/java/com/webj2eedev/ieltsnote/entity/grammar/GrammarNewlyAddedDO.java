package com.webj2eedev.ieltsnote.entity.grammar;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class GrammarNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
