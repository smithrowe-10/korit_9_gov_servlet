package com.korit.servelt_study.ch11.service;

import com.korit.servelt_study.ch11.dao.ProfessorDao;
import com.korit.servelt_study.ch11.entity.Professor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorDao professorDao;

    public List<Professor> getProfessors() {
        return professorDao.findAll();
    }
}
