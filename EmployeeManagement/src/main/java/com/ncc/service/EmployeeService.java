package com.ncc.service;

import com.ncc.entity.Employee;
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeFilterForm;
import com.ncc.form.EmployeeUpdateForm;
import com.ncc.repository.IEmployeeRepository;
import com.ncc.specification.EmployeeSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmailService emailService;


    @Override
    public Page<Employee> getAllEmployee(Pageable pageable, EmployeeFilterForm form) {
        return employeeRepository.findAll(EmployeeSpecification.buildWhere(form), pageable);
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void createEmployee(EmployeeCreateForm form) {
        Employee employee = mapper.map(form, Employee.class);

        String checkinCode = generateCheckinCode();
        employee.setCheckInCode(Integer.valueOf(checkinCode));

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeUpdateForm form) {
        employeeRepository.save(mapper.map(form, Employee.class));
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public Employee findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public void saveUser(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    private String generateCheckinCode() {
        Random random = new Random();
        int code = random.nextInt(9000) + 1000;
        return String.valueOf(code);
    }

}
