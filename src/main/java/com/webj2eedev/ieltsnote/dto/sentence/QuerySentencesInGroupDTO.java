package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QuerySentencesInGroupDTO implements Serializable {
    private Integer groupId;
    private String condition;

    // pageable
    private int pagenum;
    private int pagesize;
}
