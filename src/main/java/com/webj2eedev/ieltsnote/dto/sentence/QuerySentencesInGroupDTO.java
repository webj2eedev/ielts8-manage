package com.webj2eedev.ieltsnote.dto.sentence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuerySentencesInGroupDTO implements Serializable {
    private Integer groupId;
}
