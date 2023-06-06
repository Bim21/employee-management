package com.ncc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;
=======
import java.util.Date;
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "check_in_out")
public class CheckInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
=======
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

<<<<<<< HEAD
    private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean isError;
=======
    @Column(name = "check_in_time", nullable = false)
    private Date checkInTime;
    @Column(name = "check_out_time")
    private Date checkOutTime;

    @Column(name = "check_in_code")
    private Integer checkInCode;

    @Column(name = "is_checkIn")
    private boolean isCheckIn;
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
}
