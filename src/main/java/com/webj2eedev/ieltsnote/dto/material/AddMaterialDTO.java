package com.webj2eedev.ieltsnote.dto.material;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddMaterialDTO implements Serializable {
    private String content;
    private String comment;
    private Integer creator;
}
