package com.ncc.service;

import com.ncc.entity.CheckInOut;
import com.ncc.entity.Employee;
import com.ncc.repository.ICheckInOutRepository;
import com.ncc.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CheckInOutService implements ICheckInOutService{

    @Autowired
    private ICheckInOutRepository checkInOutRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public void checkIn(String checkInCode, Employee employee) {

    }

    @Override
    public void checkOut(String checkInCode, Employee employee) {

    }

    private boolean isCheckInCodeValid(String checkInCode, Employee employee){

        return true;
    }
}
