package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DeleteSemanticsInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer semanticsId;
    private Boolean cascade;
}
