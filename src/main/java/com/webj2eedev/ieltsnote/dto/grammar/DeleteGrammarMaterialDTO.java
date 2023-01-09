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
public class DeleteGrammarMaterialDTO implements Serializable {
    private int uid;
    private int materialId;
}
