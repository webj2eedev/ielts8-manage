package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SpeakingQAFilterDO {
    private Integer part;
    private List<String> filters;
}
