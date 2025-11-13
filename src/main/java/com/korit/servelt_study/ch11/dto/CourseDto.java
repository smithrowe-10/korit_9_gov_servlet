package com.korit.servelt_study.ch11.dto;

import com.korit.servelt_study.ch11.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private String course_code;
    private String course_name;
    private int professor_id;
    private int credit;
    private int enrollment_capacity;
    private String classroom;

    public Course toEntity() {
        return Course.builder()
                .courseCode(course_code)
                .courseName(course_name)
                .professorId(professor_id)
                .credit(credit)
                .enrollmentCapacity(enrollment_capacity)
                .classroom(classroom)
                .build();
    }

}
