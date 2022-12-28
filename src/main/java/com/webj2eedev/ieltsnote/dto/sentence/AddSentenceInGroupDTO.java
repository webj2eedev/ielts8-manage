package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddSentenceInGroupDTO implements Serializable {
    private Integer groupId;
    private String sentence;
    private Integer creator;
}
