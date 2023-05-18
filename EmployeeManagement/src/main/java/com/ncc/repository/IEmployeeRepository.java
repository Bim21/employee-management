package com.ncc.repository;

import com.ncc.dto.EmployeeCheckinInfoDTO;
import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByName(String name);

    public boolean existsByName(String name);

    public void deleteById(int id);

    @Query("SELECT e, c.checkInTime, c.CheckoutTime FROM Employee e " +
            "LEFT JOIN e.checkinInfoList c" +
            "WHERE c.checkInTime >= :startDate AND c.checkInTime <= :endDate")
    List<EmployeeCheckinInfoDTO> getEmployeeCheckinInfoInRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT e FROM Employee e" +
            "LEFT JOIN e.checkinInfoList c" +
            "WHERE (c.checkInTime IS NULL OR c.checkInTime > :endDate)" +
            "AND c.checkInTime <= :endOfMonth" +
            "ORDER BY e.fullName")
    List<Employee> getEmployeesWithCheckinErrors(LocalDate endOfMonth, LocalDateTime endDate);
}
