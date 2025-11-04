package com.korit.servelt_study.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepo {

    private static UserRepo instance;
    private List<User> users;
    private Long autoId = 0l;

    private UserRepo() {
        users = new ArrayList<>();
    }

    public static UserRepo getInstance() {

        if (Objects.isNull(instance)) {
            instance = new UserRepo();
        }
        return instance;
    }

    public void insert(User user) {
        user.setId(++autoId);
        users.add(user);
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseGet(() -> null);

    }

//    public User findByUsernameNonOptional(String username) {
//        List<User> foundUsers = users.stream()
//                .filter(user -> user.getUsername().equals(username))
//                .toList();
//
//        if (foundUsers.isEmpty()) {
//            return null;
//        }
//        return foundUsers.getFirst();
//    }

    public List<User> findAll() {
        return users;
    }



}
