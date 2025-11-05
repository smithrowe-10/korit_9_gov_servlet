package com.korit.servelt_study.ch08;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {

    private String title;
    private String content;
    private String writer;

}
