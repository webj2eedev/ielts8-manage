package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddParaphraseInGroupDTO implements Serializable {
    private Integer groupId;
    private String paraphrase;
    private Integer creator;
}
