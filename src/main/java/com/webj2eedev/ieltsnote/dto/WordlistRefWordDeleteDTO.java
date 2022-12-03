package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class WordlistRefWordDeleteDTO implements Serializable {
    private Integer refId;
    private Integer wordId;
    private Boolean cascade;
}
