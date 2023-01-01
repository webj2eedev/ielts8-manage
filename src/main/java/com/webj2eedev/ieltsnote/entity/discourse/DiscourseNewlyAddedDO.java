package com.webj2eedev.ieltsnote.entity.discourse;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class DiscourseNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
