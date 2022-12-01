package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Data
public class DictationWordDO {
    private String word;
    private Long progresscnt;
    private Long dontknowcount;
    private Long knowcount;
    private Long skipcount;
    private BigDecimal dontknowrate;
    private BigDecimal skiprate;
    private BigDecimal knowrate;
    private String creator;
    private Timestamp createTime;
}
