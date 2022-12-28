package com.webj2eedev.ieltsnote.entity.writing;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WritingSampleLinkDO {
    public static enum LinkType {
        WORD_GROUP,
        SENTENCE_GROUP,
    }

    private Integer sampleId;
    private String linkType;
    private Integer linkId;
}
