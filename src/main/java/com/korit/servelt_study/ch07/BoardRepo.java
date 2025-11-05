package com.korit.servelt_study.ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BoardRepo {

    private static BoardRepo instance;
    List<Board> boards;

    private BoardRepo() {
        boards = new ArrayList<>();
    }

    public static BoardRepo getInstance() {
        if (Objects.isNull(instance)) {
            instance = new BoardRepo();
        }
        return instance;
    }

    public void insert (Board board) {
        boards.add(board);
    }

    public List<Board> findAll() {
        return boards;
    }

}
