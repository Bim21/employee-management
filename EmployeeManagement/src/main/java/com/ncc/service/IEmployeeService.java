package com.ncc.service;

import com.ncc.entity.Employee;
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeFilterForm;
import com.ncc.form.EmployeeUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable, EmployeeFilterForm form);

    Employee findById(int id);

    void createEmployee(EmployeeCreateForm form);

    void updateEmployee(EmployeeUpdateForm form);

    void deleteEmployeeById(int id);

    boolean existsById(int id);

    Employee findByLastName(String lastName);

    void saveUser(List<Employee> employees);

}
