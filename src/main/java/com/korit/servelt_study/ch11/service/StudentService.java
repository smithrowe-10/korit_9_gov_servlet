package com.korit.servelt_study.ch11.service;

import com.korit.servelt_study.ch11.dao.StudentDao;
import com.korit.servelt_study.ch11.dto.StudentDto;
import com.korit.servelt_study.ch11.entity.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public Student save (StudentDto studentDto) {
        Student student = studentDto.toEntity();
        studentDao.insert(student);
        System.out.println(student);

        return student;
    }
}