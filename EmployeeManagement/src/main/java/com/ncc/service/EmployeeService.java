package com.ncc.service;

import com.ncc.dto.EmployeeCheckinInfoDTO;
import com.ncc.entity.Employee;
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeUpdateForm;
import com.ncc.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public Page<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void createEmployee(EmployeeCreateForm form) {
        Employee employee = mapper.map(form, Employee.class);

        String checkinCode = generateCheckinCode();
        employee.setEmployeeCode(checkinCode);

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
    public Employee findByname(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void saveUser(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    @Override
    public List<EmployeeCheckinInfoDTO> getEmployeesCheckinInfoRange(LocalDateTime startDate, LocalDateTime endDate) {
        if(startDate == null){
            startDate = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        }
        if(endDate == null){
            endDate = LocalDateTime.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        }

        List<EmployeeCheckinInfoDTO> employeeCheckinInfoDTOList = employeeRepository.getEmployeeCheckinInfoInRange(startDate, endDate);
        return  employeeCheckinInfoDTOList;
    }

    @Override
    public List<EmployeeCheckinInfoDTO> getEmployeesWithCheckinErrors() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime endDate = endOfMonth.atStartOfDay();

        List<Employee> employeesWithCheckinErrors = employeeRepository.getEmployeesWithCheckinErrors(endOfMonth, endDate);
        return null;
    }


    private String generateCheckinCode(){
        Random random = new Random();
        int code = random.nextInt(9000) + 1000;
        return String.valueOf(code);
    }
}
