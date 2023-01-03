package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSemanticsInGroupDTO implements Serializable {
    private Integer groupId;
    private String semanticsType;
    private String semanticsText;
    private Integer creator;
}
