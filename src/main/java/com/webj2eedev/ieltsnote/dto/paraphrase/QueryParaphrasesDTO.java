package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QueryParaphrasesDTO implements Serializable {
    private String condition;

    // pageable
    private int pagenum;
    private int pagesize;
}
