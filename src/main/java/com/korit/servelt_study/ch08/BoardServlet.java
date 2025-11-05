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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/ch08/boards")
public class BoardServlet extends HttpServlet {

    List<Board> boards;
    ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        boards = new ArrayList<>();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getOutputStream(), boards); `


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

//        BufferedReader br = req.getReader();
//        StringBuilder stringBuilder = new StringBuilder();
//        String read;
//
//        while (!Objects.isNull((read = br.readLine()))) {
//            stringBuilder.append(read);
//        }
//
//        String json = stringBuilder.toString();
//        System.out.println(json);

        Board board = objectMapper.readValue(req.getInputStream(), Board.class);
        boards.add(board);
        System.out.println(boards);

        Response response = new Response("게시글 작성 완료");

        objectMapper.writeValue(resp.getOutputStream(), response);
//        resp.getWriter().println(response);
    }
}
