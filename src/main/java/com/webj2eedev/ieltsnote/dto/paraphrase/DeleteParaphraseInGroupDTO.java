package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DeleteParaphraseInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer paraphraseId;
    private Boolean cascade;
}
