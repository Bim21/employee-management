package com.ncc.service;

import com.ncc.constants.MessageConstant;
import com.ncc.dto.CheckInOutDTO;
import com.ncc.dto.EmployeeDTO;
import com.ncc.dto.MailDTO;
import com.ncc.entity.CheckInOut;
import com.ncc.entity.Employee;
import com.ncc.exception.NotFoundException;
import com.ncc.repository.ICheckInOutRepository;
import com.ncc.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
<<<<<<< HEAD
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository employeeRepository;
    private final ICheckInOutRepository checkInOutRepository;
    private final ModelMapper mapper;
    private final EmailService emailService;

    public EmployeeService(IEmployeeRepository employeeRepository, ICheckInOutRepository checkInOutRepository, ModelMapper mapper, EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.checkInOutRepository = checkInOutRepository;
        this.mapper = mapper;
        this.emailService = emailService;
    }

=======
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmailService emailService;

>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    @Override
    public Page<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        String checkinCode = generateCheckinCode();
<<<<<<< HEAD
        Employee employee = mapper.map(employeeDTO, Employee.class);
        employee.setCheckInCode(Integer.valueOf(checkinCode));
        Employee saveEmployee =  employeeRepository.save(employee);
        EmployeeDTO saveEmployeeDTO = mapper.map(saveEmployee, EmployeeDTO.class);
        emailService.sendEmail(new MailDTO());
        return saveEmployeeDTO;
=======
        employee.setCheckInCode(Integer.valueOf(checkinCode));

        employeeRepository.save(employee);
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            mapper.map(employeeDTO, employee);
            Employee updatedEmployee = employeeRepository.save(employee);
            EmployeeDTO updatedEmployeeDTO = mapper.map(updatedEmployee, EmployeeDTO.class);
            return updatedEmployeeDTO;
        }else {
            throw new NotFoundException(MessageConstant.EMPLOYEE_IS_NULL);
        }
    }


    @Override
    public void deleteEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
        } else {
            throw new NotFoundException(MessageConstant.EMPLOYEE_IS_NULL);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesWithCheckinCheckoutRecords(LocalDate startDate, LocalDate endDate) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
                    List<CheckInOut> checkinRecords = checkInOutRepository.findByEmployeeAndDateBetween(employee, startDate, endDate);
                    List<CheckInOutDTO> checkinRecordDTOs = checkinRecords.stream()
                            .map(checkinRecord -> mapper.map(checkinRecord, CheckInOutDTO.class))
                            .collect(Collectors.toList());
                    employeeDTO.setCheckInRecords(checkinRecordDTOs);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
<<<<<<< HEAD
    public List<EmployeeDTO> getEmployeesWithCheckinErrorsInMonth(LocalDate date) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
                    List<CheckInOut> checkinErrors = checkInOutRepository.findCheckinErrorsByEmployeeAndMonth(employee, date.getMonthValue(), date.getYear());
                    List<CheckInOutDTO> checkinErrorDTOs = checkinErrors.stream()
                            .map(checkinError -> mapper.map(checkinError, CheckInOutDTO.class))
                            .collect(Collectors.toList());
                    employeeDTO.setCheckInErrors(checkinErrorDTOs);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
=======
    public Employee findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String keyword) {
        List<Employee> employees = employeeRepository.findByUsernameContainingIgnoreCase(keyword);
        return employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public void saveUser(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

<<<<<<< HEAD
    @Override
    public List<EmployeeDTO> searchEmployeesByName(String keyword) {
        List<Employee> employees = employeeRepository.findByUsernameContainingIgnoreCase(keyword);
        return employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

=======
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    private String generateCheckinCode() {
        Random random = new Random();
        int code = random.nextInt(9000) + 1000;
        return String.valueOf(code);
    }
}
