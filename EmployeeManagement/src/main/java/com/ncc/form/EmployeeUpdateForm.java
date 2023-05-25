package com.ncc.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeUpdateForm {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String employeeCode;
    private Date startDate;
}
