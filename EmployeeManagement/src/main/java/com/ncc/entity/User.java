package com.ncc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String userName;

    @Column(name = "password", length = 500, unique = true, nullable = false)
    private String passWord;
    @Column(name = "firstName", length = 50, nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email", length = 100, nullable = false)
    @JsonProperty("email")
    private String email;
    @Formula("concat(firstName, ' ', lastName)")
    private String fullName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
