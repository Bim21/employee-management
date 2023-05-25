package com.ncc.service;

import com.ncc.entity.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

    void activeUser(String token);

    boolean existsUserByEmail(String email);

    boolean existsUserByUserName(String userName);

}
