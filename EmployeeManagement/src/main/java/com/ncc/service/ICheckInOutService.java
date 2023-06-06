package com.ncc.service;

import com.ncc.dto.CheckInOutDTO;
import com.ncc.entity.Employee;

public interface ICheckInOutService {
    CheckInOutDTO checkIn(String checkInCode);
    CheckInOutDTO checkOut(String checkInCode);
}
