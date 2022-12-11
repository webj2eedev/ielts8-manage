package com.webj2eedev.ieltsnote.dto.word;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddWordDTO implements Serializable {
    private String word;
    private Integer creator;
}
