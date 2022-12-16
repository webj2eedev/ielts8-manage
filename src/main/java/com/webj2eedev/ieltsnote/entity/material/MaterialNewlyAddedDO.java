package com.webj2eedev.ieltsnote.entity.material;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaterialNewlyAddedDO {
    private Long count;
    private String time;
}
