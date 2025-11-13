package com.korit.servelt_study.ch11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Department {
    private int departmentId;
    private String departmentCode, departmentName;
}
