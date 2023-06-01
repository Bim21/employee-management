package com.ncc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstName", length = 50, nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Formula("concat(firstName, ' ', lastName)")
    private String fullName;

    @Column(name = "email", length = 100, nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(name = "check_in_code", unique = true)
    private Integer checkInCode;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'EMPLOYEE'")
    private Role role = Role.EMPLOYEE;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
}
