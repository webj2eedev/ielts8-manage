package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddParaphraseDTO implements Serializable {
    private String text;
    private Integer creator;
}
