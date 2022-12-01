package com.webj2eedev.ieltsnote.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StorylineCategoryDTO {
    private Integer id;
    private Integer parentId;
    private Integer order;
    private String label;
    private String comment;
    private Integer wordCategoryId;
    private Integer translationCategoryId;
    private Integer collocationCategoryId;
    private Integer cohesionAndCoherenceCategoryId;
    private Integer readingMaterialCategoryId;
    private Integer idiomCategoryId;
    private Integer synonymsSubstitutionCategoryId;

}
