package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QuerySemanticssInGroupDTO implements Serializable {
    private Integer groupId;
    private String condition;
}
