package com.ncc.service;

import com.ncc.dto.EmployeeDTO;
import com.ncc.entity.Employee;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee();

    Employee findById(int id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployeeById(int id);

    List<EmployeeDTO > getAllEmployeesWithCheckinCheckoutRecords(LocalDate startDate, LocalDate endDate);
    List<EmployeeDTO> getEmployeesWithCheckinErrorsInMonth(LocalDate date);
    List<EmployeeDTO> searchEmployeesByName(String keyword);

    void saveUser(List<Employee> employees);

}
