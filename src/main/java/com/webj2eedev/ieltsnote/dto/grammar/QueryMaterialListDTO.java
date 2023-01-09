package com.webj2eedev.ieltsnote.dto.grammar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryMaterialListDTO implements Serializable {
    private Integer categoryId;
}
