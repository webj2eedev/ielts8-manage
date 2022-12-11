package com.webj2eedev.ieltsnote.dto.word;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddWordGroupDTO implements Serializable {
    private String label;
    private Integer creator;
}
