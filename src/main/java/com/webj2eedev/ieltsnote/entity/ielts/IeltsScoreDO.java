package com.webj2eedev.ieltsnote.entity.ielts;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Data
public class IeltsScoreDO {
    private int uid;
    private BigDecimal listening;
    private BigDecimal speaking;
    private BigDecimal reading;
    private BigDecimal writing;
    private BigDecimal overall;
    private Timestamp testDate;
}
