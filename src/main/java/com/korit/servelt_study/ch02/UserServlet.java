package com.korit.servelt_study.ch02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ch02/users")
public class UserServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // username == "test"

        String username = req.getParameter("username");

        boolean found = false;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println(user);
                resp.setStatus(HttpServletResponse.SC_OK);
                found = true;
                break;
            }
        }
        if (!found) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("해당 username은 존재하지 않습니다.");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User user = new User(username, password, name, email);

        users.add(user);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(users);

        System.out.println(users);
    }
}
