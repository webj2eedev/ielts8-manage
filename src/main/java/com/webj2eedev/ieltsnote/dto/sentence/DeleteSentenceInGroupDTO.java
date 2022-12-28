package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DeleteSentenceInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer sentenceId;
    private Boolean cascade;
}
