package com.ncc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String userName;

    @Column(name = "password", length = 800, nullable = false, unique = true)
    private String passWord;
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Formula("concat(firstName, ' ', lastName)")
    private String fullName;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
}
