package com.korit.servelt_study.ch11.service;

import com.korit.servelt_study.ch11.dao.CourseDao;
import com.korit.servelt_study.ch11.dto.CourseDto;
import com.korit.servelt_study.ch11.entity.Course;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseService {

    private final CourseDao courseDao;

    public Course save (CourseDto courseDto) {
        Course course = courseDto.toEntity();
        courseDao.insert(course);
        System.out.println(course);

        return course;
    }
}