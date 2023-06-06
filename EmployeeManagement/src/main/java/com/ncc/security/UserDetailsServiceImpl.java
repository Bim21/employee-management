package com.ncc.security;

import com.ncc.entity.Employee;
import com.ncc.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final IEmployeeRepository employeeRepository;

    @Autowired
    public UserDetailsServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUserName(username);
        if(employee == null){
            throw new UsernameNotFoundException("User" + username + "was not found in the database");
        }
        return UserDetailsImpl.build(employee);
    }
}
