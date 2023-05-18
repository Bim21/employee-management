package com.ncc.service;

import com.ncc.dto.EmployeeCheckinInfoDTO;
import com.ncc.entity.Employee;
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee();

    Employee findById(int id);
    void createEmployee(EmployeeCreateForm form);

    void updateEmployee(EmployeeUpdateForm form);

    void deleteEmployeeById(int id);

    boolean existsById(int id);

    Employee findByname(String name);

    void saveUser(List<Employee> employees);
    List<EmployeeCheckinInfoDTO> getEmployeesCheckinInfoRange(LocalDateTime startDate, LocalDateTime endDate);

    List<EmployeeCheckinInfoDTO> getEmployeesWithCheckinErrors();
}
