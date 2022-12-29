package com.webj2eedev.ieltsnote.dto.word;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddWordGroupDTO implements Serializable {
    private Integer creator;
}
