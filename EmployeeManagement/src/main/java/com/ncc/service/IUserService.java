package com.ncc.service;

import com.ncc.entity.User;
import com.ncc.form.UserCreateForm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService extends UserDetailsService{

    void createUser(UserCreateForm form);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

    void activeUser(String token);

    boolean existsUserByEmail(String email);

    boolean existsUserByUserName(String userName);

}
