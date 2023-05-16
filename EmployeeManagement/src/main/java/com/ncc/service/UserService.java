package com.ncc.service;

import com.ncc.entity.User;

public class UserService implements IUserService{
    @Override
    public void createUser(User user) {

    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public void activeUser(String token) {

    }

    @Override
    public void sendConfirmUserRegistrationViaEmail(String email) {

    }

    @Override
    public boolean existsUserByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsUserByUserName(String userName) {
        return false;
    }
}
