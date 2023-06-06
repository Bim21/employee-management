package com.ncc.service;

import com.ncc.constants.MessageConstant;
import com.ncc.dto.CheckInOutDTO;
import com.ncc.entity.CheckInOut;
import com.ncc.entity.Employee;
import com.ncc.exception.CheckinException;
import com.ncc.exception.EmployeeNotFoundException;
import com.ncc.repository.ICheckInOutRepository;
import com.ncc.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CheckInOutService implements ICheckInOutService {

    private final ICheckInOutRepository checkInOutRepository;
    private final IEmployeeRepository employeeRepository;
    private final IEmailService emailService;
    private final ModelMapper mapper;

    @Autowired
    public CheckInOutService(ICheckInOutRepository checkInOutRepository, IEmployeeRepository employeeRepository, IEmailService emailService, ModelMapper mapper) {
        this.checkInOutRepository = checkInOutRepository;
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
        this.mapper = mapper;
    }

    @Override
    public CheckInOutDTO checkIn(String checkInCode) {
        Employee employee = employeeRepository.findByCheckInCode(checkInCode);
        if (employee == null) {
            throw new EmployeeNotFoundException(MessageConstant.EMPLOYEE_IS_NULL);

        }

        boolean hasCheckInOut = checkInOutRepository.existsByEmployeeAndCheckoutTimeIsNull(employee);
        if (hasCheckInOut) {
            throw new CheckinException(MessageConstant.CHECK_IN_SUCCESSFULLY);
        }

        CheckInOut checkInOut = new CheckInOut();
        checkInOut.setEmployee(employee);
        checkInOut.setCheckInTime(LocalDateTime.now());

        CheckInOut saveCheckInOut = checkInOutRepository.save(checkInOut);
        return mapper.map(saveCheckInOut, CheckInOutDTO.class);
    }

    @Override
    public CheckInOutDTO checkOut(String checkInCode) {
        Employee employee = employeeRepository.findByCheckInCode(checkInCode);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        CheckInOut checkInOut = checkInOutRepository.findByEmployeeAndCheckOutTimeIsNull(employee);
        if (checkInOut == null) {
            throw new CheckinException(MessageConstant.CHECK_IN_FAILED);
        }

        checkInOut.setCheckOutTime(LocalDateTime.now());

        CheckInOut saveCheckInOut = checkInOutRepository.save(checkInOut);
        return mapper.map(saveCheckInOut, CheckInOutDTO.class);
    }
}
