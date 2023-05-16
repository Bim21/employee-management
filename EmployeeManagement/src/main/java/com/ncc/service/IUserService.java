package com.ncc.service;

import com.ncc.entity.User;

public interface IUserService {
    void createUser(User user);

    User findUserByEmail(String email);
    
}
