package com.webj2eedev.ieltsnote.dto.paraphrase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryParaphraseDTO implements Serializable {
    private int uid;
}
