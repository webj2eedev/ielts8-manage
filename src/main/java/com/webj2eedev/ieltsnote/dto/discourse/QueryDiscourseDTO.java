package com.webj2eedev.ieltsnote.dto.discourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDiscourseDTO implements Serializable {
    private int uid;
}
