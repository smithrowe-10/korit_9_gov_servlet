package com.korit.servelt_study.ch09;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class StudentRepo {

    List<Student> students;
    private static StudentRepo instance;
    private int autoId = 20250001;

    public StudentRepo() {
        students = new ArrayList<>();
    }

    public static StudentRepo getInstance() {
        if (Objects.isNull(instance)) {
            instance = new StudentRepo();
        }
        return instance;
    }

    public List<Student> findAllBySearchNameValue(String searchNameValue) {
        if (Objects.isNull(searchNameValue)) {
            return students;
        }
        return students.stream()
                .filter(student -> student.getName().contains(searchNameValue))
                .toList();
    }

    public void addList (Student student) {
        student.setId(autoId++);
        students.add(student);
        System.out.println(students);
    }

}
