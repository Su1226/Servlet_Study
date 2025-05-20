package com.korit.springboot.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class SearchStudentDto {
    private String SearchValue;
    private Integer page = 1;
    private Integer count = 10;
}
