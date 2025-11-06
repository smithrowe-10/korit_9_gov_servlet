package com.korit.servelt_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/study/students")
public class StudentServlet extends HttpServlet {

    ObjectMapper objectMapper;
    StudentRepo students;
    Response response;


    @Override
    public void init(ServletConfig config) throws ServletException {
        students = StudentRepo.getInstance();
        objectMapper = new ObjectMapper();
        response = new Response("정보등록 완료");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchNameValue = req.getParameter("searchName");
        if (Objects.isNull(searchNameValue)) {
            objectMapper.writeValue(resp.getWriter(),students);
            return;
        }

        List<Student> foundStudents = students.getStudents().stream()
                        .filter(student -> student.getName().contains(searchNameValue))
                                .toList();


        objectMapper.writeValue(resp.getWriter(), foundStudents);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Student student = objectMapper.readValue(req.getInputStream(), Student.class);

        students.addList(student);
        System.out.println(students);

        objectMapper.writeValue(resp.getWriter(), response);

    }
}
