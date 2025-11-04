package com.korit.servelt_study.ch03;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/*
    JSON 형식
{
    "username": "test",
    "password": "1234",
    "name": "김준일",
    "email": "test@gmail.com"
}
 */

@WebServlet("/ch03/users")
public class UserServlet extends HttpServlet {

    private UserRepo userRepo;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userRepo = UserRepo.getInstance();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        List<User> users = userRepo.findAll();
        objectMapper.writeValue(resp.getWriter(), users);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(req.getInputStream()));
//        StringBuilder builder = new StringBuilder();
//
//        while (true) {
//            String line = bufferedReader.readLine();
//            if (Objects.isNull(line)) {
//                break;
//            }
//            builder.append(line);
//        }
//        UserDto userDto = objectMapper.readValue(builder.toString(), UserDto.class);

        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);
        System.out.println(userDto);

        User foundUser = userRepo.findByUsername(userDto.getUsername());

        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        if (!Objects.isNull(foundUser)) {
            ErrorResponse error = ErrorResponse.builder()
                    .status(HttpServletResponse.SC_BAD_REQUEST)
                    .message("이미 존재하는 username입니다.")
                    .build();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            objectMapper.writeValue(resp.getWriter(), error);
            return;
        }

        User userEntity = userDto.toUser();
        userRepo.insert(userEntity);

        SuccessResponse<User> successResponse = SuccessResponse.<User> builder()
                .status(HttpServletResponse.SC_OK)
                .message("사용자 등록을 완료하였습니다.")
                .body(userEntity)
                .build();
        objectMapper.writeValue(resp.getWriter(), successResponse);
    }

}
