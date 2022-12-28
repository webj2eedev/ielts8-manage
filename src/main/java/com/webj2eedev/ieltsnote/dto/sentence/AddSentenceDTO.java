package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSentenceDTO implements Serializable {
    private String content;
    private Integer creator;
}
