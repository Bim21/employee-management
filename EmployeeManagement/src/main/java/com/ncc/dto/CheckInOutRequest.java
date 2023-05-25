package com.ncc.dto;

import com.ncc.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CheckInOutRequest {
    private int id;
    private int isCheckIn;
}
