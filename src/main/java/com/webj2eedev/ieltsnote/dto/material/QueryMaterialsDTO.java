package com.webj2eedev.ieltsnote.dto.material;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class QueryMaterialsDTO implements Serializable {
    private String condition;

    // pageable
    private int pagenum;
    private int pagesize;
}
