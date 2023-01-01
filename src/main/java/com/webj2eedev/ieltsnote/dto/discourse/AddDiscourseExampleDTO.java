package com.webj2eedev.ieltsnote.dto.discourse;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddDiscourseExampleDTO implements Serializable {
    private Integer discourseId;
    private String example;
    private String comment;
    private Integer creator;
}
