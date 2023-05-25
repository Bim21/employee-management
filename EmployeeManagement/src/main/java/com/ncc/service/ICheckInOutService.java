package com.ncc.service;

import com.ncc.entity.Employee;

public interface ICheckInOutService {
    void checkIn(String checkInCode, Employee employee);
    void checkOut(String checkInCode, Employee employee);
}
