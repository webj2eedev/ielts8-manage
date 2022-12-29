package com.webj2eedev.ieltsnote.entity.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ParaphraseNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
