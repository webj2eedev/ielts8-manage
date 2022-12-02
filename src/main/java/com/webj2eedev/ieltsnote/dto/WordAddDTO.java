package com.webj2eedev.ieltsnote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class WordAddDTO implements Serializable {
    private String word;
    private Integer creator;
}
