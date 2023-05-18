package com.ncc.repository;

import com.ncc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
//    public boolean existsByUserName(String userName);


    public boolean existsByEmail(String email);

//    public User findByUserName(String name);

    public User findByEmail(String email);

}
