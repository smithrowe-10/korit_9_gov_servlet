package com.korit.servelt_study.ch03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class UserDto {

    private String username;
    private String password;
    private String name;
    private String email;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }

}
