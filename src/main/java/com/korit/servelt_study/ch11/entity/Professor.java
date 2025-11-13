package com.korit.servelt_study.ch11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Professor {

    private int professorID;
    private String professorName;

}
