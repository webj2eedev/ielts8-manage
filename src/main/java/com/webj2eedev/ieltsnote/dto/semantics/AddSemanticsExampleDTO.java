package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSemanticsExampleDTO implements Serializable {
    private Integer semanticsId;
    private String example;
    private String comment;
    private Integer creator;
}
