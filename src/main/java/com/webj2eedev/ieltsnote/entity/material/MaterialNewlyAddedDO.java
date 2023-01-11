package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class MaterialNewlyAddedDO {
    private String time;
    private Long increment;
    private BigDecimal total;
}
