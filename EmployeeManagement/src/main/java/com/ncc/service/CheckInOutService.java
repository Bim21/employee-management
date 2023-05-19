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
    public void checkIn(int id) {
        // Lấy thng tin nhân viên từ bảng employee
        Employee employee = employeeRepository.findById(id).orElse(null);

        if(employee != null){
            //Lấy mã check-in từ nhân viên
            int checkInCode = employee.getCheckInCode();

            // Thực hiện quá trình check-in và lưu vào bảng check_in_out
            CheckInOut checkInOut = new CheckInOut();
            checkInOut.setEmployee(employee);
            checkInOut.setCheckInCode(checkInCode);
            checkInOut.setCheckInTime(new Date());

            checkInOutRepository.save(checkInOut);

        } else {
            throw new EmployeeNotFoundException("Không tìm thấy nhân viên với ID cung cấp: " + id);
        }
    }
}
