package com.webj2eedev.ieltsnote.dto.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryMaterialAttachmentsDTO implements Serializable {
    private int materialId;
}
