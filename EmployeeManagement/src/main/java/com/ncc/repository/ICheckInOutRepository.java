package com.ncc.repository;

import com.ncc.entity.CheckInOut;
import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICheckInOutRepository extends JpaRepository<CheckInOut, Long> {

}
