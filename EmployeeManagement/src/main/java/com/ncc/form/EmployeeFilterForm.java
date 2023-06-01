package com.ncc.form;

import com.ncc.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeFilterForm {
    private String search;
    private Integer minId;
    private Integer maxId;
}
