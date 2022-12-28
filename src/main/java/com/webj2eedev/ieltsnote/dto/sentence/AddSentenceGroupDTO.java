package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSentenceGroupDTO implements Serializable {
    private String label;
    private Integer creator;
}
