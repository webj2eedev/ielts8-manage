package com.webj2eedev.ieltsnote.dto.material;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DeleteMaterialInGroupDTO implements Serializable {
    private Integer groupId;
    private Integer materialId;
}
