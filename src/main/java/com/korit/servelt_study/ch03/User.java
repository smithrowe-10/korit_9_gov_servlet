package com.korit.servelt_study.ch03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class User {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;

}
