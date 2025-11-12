package com.korit.servelt_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/study/study")
public class StudyServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentRepo studentRepo = (StudentRepo) req.getServletContext().getAttribute("sr");
        objectMapper.writeValue(resp.getWriter(), studentRepo.findAllBySearchNameValue(null));

    }

}
/*
    싱글턴을 안쓰면 생기는 개줮같은 일 ->
        최초로 생성한 config.getServletContext().setAttribute("sr", studentRepo);
        를 다른 사람이 못찾고 또쳐만들까봐 StudentRepo에 싱글턴으로 박아놓음
 */