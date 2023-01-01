package com.webj2eedev.ieltsnote.dto.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QueryDiscoursesDTO implements Serializable {
    private String condition;

    // pageable
    private int pagenum;
    private int pagesize;
}
