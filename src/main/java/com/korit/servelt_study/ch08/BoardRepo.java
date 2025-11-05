package com.korit.servelt_study.ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardRepo {

    List<Board> boards;
    private static BoardRepo instance;

    public BoardRepo() {
        boards = new ArrayList<>();
    }

    public static BoardRepo getInstance() {
        if (Objects.isNull(instance)) {
            return instance = new BoardRepo();
        }
        return instance;
    }



}
