package com.webj2eedev.ieltsnote.dto.word;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DeleteWordInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer wordId;
    private Boolean cascade;
}
