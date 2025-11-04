package com.korit.servelt_study.ch02;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@Builder

public class User {

    private String username;
    private String password;
    private String name;
    private String email;


}
