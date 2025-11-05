package com.korit.servelt_study.ch07;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ch07/boards")
public class BoardServlet extends HttpServlet {

    private BoardRepo boardRepo;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        boardRepo = BoardRepo.getInstance();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        List<Board> boards = boardRepo.findAll();
        objectMapper.writeValue(resp.getWriter(), boards);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardDto boardDto = objectMapper.readValue(req.getInputStream(), BoardDto.class);

        resp.setContentType("application/json");

        Board board = boardDto.toBoard();

    }
}
