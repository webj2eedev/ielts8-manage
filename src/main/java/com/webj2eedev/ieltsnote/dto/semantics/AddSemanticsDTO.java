package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSemanticsDTO implements Serializable {
    private String type;
    private String text;
    private Integer creator;
}
