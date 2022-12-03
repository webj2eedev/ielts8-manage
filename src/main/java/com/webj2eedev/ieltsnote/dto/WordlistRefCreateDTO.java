package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class WordlistRefCreateDTO implements Serializable {
    private String label;
    private Integer creator;
}
