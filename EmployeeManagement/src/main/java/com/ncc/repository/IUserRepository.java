package com.ncc.repository;

import com.ncc.entity.User;
<<<<<<< HEAD
import com.ncc.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Integer> {

    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);

    @Query(" SELECT status" +
            "FROM User" +
            "WHERE email = :email")
    public UserStatus findStatusByEmail(@Param("email") String email);

    public User findByUserName(String name);

    public User findByEmail(String email);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    public boolean existsByEmail(String email);

    public User findByEmail(String email);

>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
}
