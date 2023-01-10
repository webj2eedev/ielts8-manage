package com.webj2eedev.ieltsnote.dto.grammar;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddGrammarSentenceInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer grammarCategoryId;
    private Integer grammarSentenceId;
    private Integer creator;
}
