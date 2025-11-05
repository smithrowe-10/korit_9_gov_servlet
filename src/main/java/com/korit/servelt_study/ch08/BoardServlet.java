package com.korit.servelt_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/ch08/boards")
public class BoardServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        BufferedReader br = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String read;

        while ((read = br.readLine()) != null) {
            stringBuilder.append(read);
        }

        String json = stringBuilder.toString();
        System.out.println(json);



    }
}
