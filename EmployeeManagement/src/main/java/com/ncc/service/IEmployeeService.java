package com.ncc.service;

import com.ncc.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee();

    Employee findById(int id);
    void createEmployee();

    void updateEmployee(int id);

    void deleteEmployees(List<Integer> ids );

    boolean existsById(int id);

    Employee findByname(String name);

    void saveUser(List<Employee> employees);
}
