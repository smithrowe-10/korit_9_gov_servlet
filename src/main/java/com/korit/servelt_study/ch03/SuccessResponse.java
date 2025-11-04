package com.korit.servelt_study.ch03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SuccessResponse <T> {

    private int status = 200;
    private String message;
    private T body;

}
