package com.ncc.service;

import com.ncc.dto.EmployeeDTO;
import com.ncc.entity.Employee;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee();

    Employee findById(int id);
<<<<<<< HEAD
=======

    void createEmployee(EmployeeCreateForm form);
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployeeById(int id);

    List<EmployeeDTO > getAllEmployeesWithCheckinCheckoutRecords(LocalDate startDate, LocalDate endDate);
    List<EmployeeDTO> getEmployeesWithCheckinErrorsInMonth(LocalDate date);

<<<<<<< HEAD
    List<EmployeeDTO> searchEmployeeByName(String keyword);

    void saveUser(List<Employee> employees);

    List<EmployeeDTO> searchEmployeesByName(String keyword);
=======
    Employee findByLastName(String lastName);

    void saveUser(List<Employee> employees);

>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
}
