package com.ncc.repository;

import com.ncc.entity.RegistrationUserToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationUserTokenRepository {

    public RegistrationUserToken findByToken(String token);

    @Query("SELECT token" +
            "FROM RegistrationUserToken" +
            "WHERE  user.id = :userId")
    public String findByUserId(@Param("userId") int userId);

    @Query("DELETE" +
            "FROM RegistrationUserToken" +
            "WHERE user.id = :userId")
    public void deleteByUserId(@Param("userId") int userId);
}
