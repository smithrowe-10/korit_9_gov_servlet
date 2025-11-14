package com.korit.servelt_study.ch11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servelt_study.ch11.dao.ProfessorDao;
import com.korit.servelt_study.ch11.dao.ProfessorDaoName;
import com.korit.servelt_study.ch11.entity.Professor;
import com.korit.servelt_study.ch11.service.ProfessorService;
import com.korit.servelt_study.ch11.util.DBConnectionMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/professors")
public class ProfessorServlet extends HttpServlet {

    private ProfessorService professorService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        professorService = new ProfessorService(new ProfessorDaoName(DBConnectionMgr.getInstance()));
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        List<Professor> professors = professorService.getProfessors(q);
        objectMapper.writeValue(resp.getWriter(), professors);
    }
}
// 만드는 순서 : POST 맨 -> Servlet