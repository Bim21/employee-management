package com.ncc.form;

import com.ncc.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateForm {
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private Role role;
}
