package com.ncc.service;

import com.ncc.entity.User;

public interface IUserService {
    void createUser(User user);

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

    void activeUser(String token);

    void sendConfirmUserRegistrationViaEmail(String email);

    boolean existsUserByEmail(String email);

    boolean existsUserByUserName(String userName);
}