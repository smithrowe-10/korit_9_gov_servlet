package com.korit.servelt_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/study/students")
public class StudentServlet extends HttpServlet {

    private ObjectMapper objectMapper;
    private StudentRepo studentRepo;
    private Response response;


    @Override
    public void init(ServletConfig config) throws ServletException {

        studentRepo = StudentRepo.getInstance();
        objectMapper = new ObjectMapper();
        response = new Response("정보등록 완료");
        config.getServletContext().setAttribute("sr", studentRepo);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchNameValue = req.getParameter("searchName");

        objectMapper.writeValue(resp.getWriter(), studentRepo.findAllBySearchNameValue(searchNameValue));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Student student = objectMapper.readValue(req.getInputStream(), Student.class);

        studentRepo.addList(student);

        objectMapper.writeValue(resp.getWriter(), response);

    }
}
