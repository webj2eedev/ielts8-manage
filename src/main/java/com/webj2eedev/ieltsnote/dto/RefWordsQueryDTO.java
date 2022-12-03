package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class RefWordsQueryDTO implements Serializable {
    private Integer refId;
    private String condition;

    // pageable
    private int pagenum;
    private int pagesize;
}
