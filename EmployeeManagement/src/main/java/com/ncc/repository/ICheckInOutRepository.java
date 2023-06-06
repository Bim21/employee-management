package com.ncc.repository;

import com.ncc.entity.CheckInOut;
import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICheckInOutRepository extends JpaRepository<CheckInOut, Long> {


    List<CheckInOut> findByEmployeeAndDateBetween(Employee employee, LocalDate startDate, LocalDate endDate);

    List<CheckInOut> findCheckinErrorsByEmployeeAndMonth(Employee employee, int monthValue, int year);
}
=======

import java.util.List;

public interface ICheckInOutRepository extends JpaRepository<CheckInOut, Long> {

}
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
