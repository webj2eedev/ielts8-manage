package com.webj2eedev.ieltsnote.dto.semantics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSemanticsGroupDTO implements Serializable {
    private Integer creator;
}
