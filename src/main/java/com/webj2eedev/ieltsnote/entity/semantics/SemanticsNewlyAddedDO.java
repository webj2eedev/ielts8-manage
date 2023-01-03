package com.webj2eedev.ieltsnote.entity.semantics;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class SemanticsNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
