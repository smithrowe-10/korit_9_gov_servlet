package com.korit.servelt_study.ch09;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class StudentRepo {

    List<Student> students;
    private static StudentRepo instance;

    public StudentRepo() {
        students = new ArrayList<>();
    }

    public static StudentRepo getInstance() {
        if (Objects.isNull(instance)) {
            instance = new StudentRepo();
        }
        return instance;
    }

    public void addList (Student student) {
        students.add(student);
    }

}
