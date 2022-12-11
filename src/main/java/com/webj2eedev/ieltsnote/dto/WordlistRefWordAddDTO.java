package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class WordlistRefWordAddDTO implements Serializable {
    private Integer groupId;
    private String word;
    private Integer creator;
}
