package com.webj2eedev.ieltsnote.dto.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QueryDiscoursesInGroupDTO implements Serializable {
    private Integer groupId;
    private String condition;
}
