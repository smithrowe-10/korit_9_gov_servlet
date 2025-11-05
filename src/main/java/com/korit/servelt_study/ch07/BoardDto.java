package com.korit.servelt_study.ch07;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {

    private String title;
    private String content;
    private String writer;

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
