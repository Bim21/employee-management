package com.ncc.service;

import com.ncc.entity.Employee;
import com.ncc.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
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

    @Override
    public void saveUser(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}
