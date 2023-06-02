package com.ncc.repository;

import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByLastName(String lastName);

    public boolean existsByLastName(String lastName);

    public void deleteById(int id);

}
