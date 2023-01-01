package com.webj2eedev.ieltsnote.dto.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddDiscourseDTO implements Serializable {
    private String type;
    private String text;
    private Integer creator;
}
