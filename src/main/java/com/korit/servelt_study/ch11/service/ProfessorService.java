package com.korit.servelt_study.ch11.service;

import com.korit.servelt_study.ch11.dao.ProfessorDaoName;
import com.korit.servelt_study.ch11.entity.Professor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorDaoName professorDaoName;

    public List<Professor> getProfessors(String query) {
        return professorDaoName.findAllLikeName(query);
    }
}