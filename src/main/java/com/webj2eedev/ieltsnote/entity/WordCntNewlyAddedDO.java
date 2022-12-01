package com.webj2eedev.ieltsnote.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WordCntNewlyAddedDO {
    private Long count;
    private String time;
}
