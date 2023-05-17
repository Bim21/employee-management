package com.ncc.service;

import com.ncc.entity.RegistrationUserToken;
import com.ncc.entity.User;
import com.ncc.repository.IUserRepository;
import com.ncc.repository.RegistrationUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
//    @Autowired
//    private RegistrationUserTokenRepository registrationUserTokenRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);

    }

    private void createNewRegistrationUserToken(User user) {
//        final String newToken = UUID.randomUUID().toString();
//        RegistrationUserToken token = new RegistrationUserToken(newToken, user);

    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

//    @Override
//    public User findUserByUserName(String userName) {
//        return null;
//    }

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

//    @Override
//    public boolean existsUserByUserName(String userName) {
//        return false;
//    }

    @Override
    public void saveUser(List<User> users) {
        userRepository.saveAll(users);
    }
}
