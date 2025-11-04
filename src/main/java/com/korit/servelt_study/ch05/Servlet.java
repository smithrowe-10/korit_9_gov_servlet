package com.korit.servelt_study.ch05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Servlet {

    private String url;

    public void doGet(Request req, Response resp) {

    }

    public void doPost(Request req, Response resp) {

    }

}
