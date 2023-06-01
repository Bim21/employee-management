package com.ncc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "check_in_out")
public class CheckInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "check_in_time", nullable = false)
    private Date checkInTime;
    @Column(name = "check_out_time")
    private Date checkOutTime;

    @Column(name = "check_in_code")
    private Integer checkInCode;

    @Column(name = "is_checkIn")
    private boolean isCheckIn;
}
