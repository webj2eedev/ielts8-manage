package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class WordLogDO {
    private int uid;
    private int creator;
    private int count;
    private Timestamp logTime;
}
