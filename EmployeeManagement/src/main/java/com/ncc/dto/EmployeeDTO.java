package com.ncc.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String employeeCode;
    private Date checkInTime;
    private Date checkOutTime;
    private Date startDate;
}
