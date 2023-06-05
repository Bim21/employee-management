package com.ncc.service;

import com.ncc.entity.User;

import com.ncc.form.UserCreateForm;
import com.ncc.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
public class UserService implements IUserService {


    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserCreateForm form) {
        String hash = passwordEncoder.encode(form.getPassWord());
        User user = mapper.map(form, User.class);
        user.setPassWord(hash);
        userRepository.save(user);
//        String to = user.getEmail();
//        String subject = "Thong bao tao moi user";
//        String content = "Chao" + user.getFullName() + ", \n\n"
//                + "Chúng tôi xin thông báo rằng bạn đã được tạo mới thành công trong hệ thống.\n"
//                + "Vui lòng liên hệ với quản lý để biết thêm thông tin chi tiết.\n\n"
//                + "Trân trọng,\n"
//                + "Ban quản lý nhân sự";
//        emailService.sendEmail(to, subject, content);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            System.out.println("User not found!" + username);
            throw new UsernameNotFoundException("User" + username + "was not found in the database");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassWord(),
                AuthorityUtils.createAuthorityList(user.getRole().toString())
        );
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

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
}
