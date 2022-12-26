package com.webj2eedev.ieltsnote.dto.writing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuerySamplesDTO implements Serializable {
    private int categoryId;
}
