package com.webj2eedev.ieltsnote.entity.writing;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WritingNewlyAddedDO {
    private String time;
    private BigDecimal task1;
    private BigDecimal task2;
}
