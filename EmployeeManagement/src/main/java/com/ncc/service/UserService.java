package com.ncc.service;

import com.ncc.entity.User;
<<<<<<< HEAD

public class UserService implements IUserService{
    @Override
    public void createUser(User user) {

=======
import com.ncc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    IEmailService emailService;

    @Override
    public void createUser(User user) {
        userRepository.save(user);

        String to = user.getEmail();
        String subject = "Thong bao tao moi user";
        String content = "Chao" + user.getFullName() + ", \n\n"
                + "Chúng tôi xin thông báo rằng bạn đã được tạo mới thành công trong hệ thống.\n"
                + "Vui lòng liên hệ với quản lý để biết thêm thông tin chi tiết.\n\n"
                + "Trân trọng,\n"
                + "Ban quản lý nhân sự";
        emailService.sendEmail(to, subject, content);
>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }
<<<<<<< HEAD
=======

    @Override
    public void activeUser(String token) {

    }


    @Override
    public boolean existsUserByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsUserByUserName(String userName) {
        return false;
    }

>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
}
