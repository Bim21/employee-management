package com.ncc.service;

import com.ncc.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    @Override
    public Page<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void createEmployee() {

    }

    @Override
    public void updateEmployee(int id) {

    }

    @Override
    public void deleteEmployees(List<Integer> ids) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public Employee findByname(String name) {
        return null;
    }
}
