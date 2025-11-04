package com.korit.servelt_study.ch05;

public class ServletA extends Servlet{

    @Override
    public void doGet(Request req, Response resp) {
        System.out.println("서블릿 A에서 GET 호출");
    }

    @Override
    public void doPost(Request req, Response resp) {
        System.out.println("서블릿 A에서 POST 호출");

    }
}
