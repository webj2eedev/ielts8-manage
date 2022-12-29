package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddParaphraseRewriteDTO implements Serializable {
    private Integer paraphraseId;
    private String rewrite;
    private String comment;
    private Integer creator;
}
