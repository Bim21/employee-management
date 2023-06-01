package com.ncc.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCreateForm {
    private String firstName;
    private String lastName;
    private String email;
    private int employeeCode;
    private Date startDate;
}
