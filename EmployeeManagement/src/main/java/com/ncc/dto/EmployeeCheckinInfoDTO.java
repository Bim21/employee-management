package com.ncc.dto;

import com.ncc.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCheckinInfoDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String employeeCode;
    private Date checkInTime;
    private Date checkOutTime;
    private Role role;
}
