package com.ncc.repository;

import com.ncc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);

    public User findByUserName(String name);

    public User findByEmail(String email);

}
