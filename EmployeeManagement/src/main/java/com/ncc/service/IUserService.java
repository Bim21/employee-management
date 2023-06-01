package com.ncc.service;

import com.ncc.entity.User;

<<<<<<< HEAD
public interface IUserService {

=======
import java.util.List;

public interface IUserService {
>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
    void createUser(User user);

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

<<<<<<< HEAD
=======
    void activeUser(String token);

    boolean existsUserByEmail(String email);

    boolean existsUserByUserName(String userName);
>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271

}
