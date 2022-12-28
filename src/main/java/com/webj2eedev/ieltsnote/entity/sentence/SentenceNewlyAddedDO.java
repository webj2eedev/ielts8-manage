package com.webj2eedev.ieltsnote.entity.sentence;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class SentenceNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
