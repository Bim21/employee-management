package com.ncc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name", length = 50, nullable = false)
    private String CompanyName;

    @Column(name = "company_address", length = 255, nullable = false)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Employee> listEmployee = new ArrayList<>();
}
