package com.ncc.controller;

import com.ncc.dto.UserDTO;
import com.ncc.entity.User;
import com.ncc.form.UserCreateForm;
import com.ncc.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private ModelMapper mapper;

    @Autowired
    public AuthController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    private IUserService service;

    @Autowired
    public AuthController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public UserDTO login(Principal principal) {
        String userName = principal.getName();
        User user = service.findUserByUserName(userName);
        return mapper.map(user, UserDTO.class);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserCreateForm form) {
        service.createUser(form);
    }
}
