package com.ncc.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String employeeCode;
    private List<CheckInOutDTO> checkInRecords;
    private List<CheckInOutDTO> checkInErrors;
}
