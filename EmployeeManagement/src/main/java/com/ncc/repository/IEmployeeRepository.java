package com.ncc.repository;

import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByUserName(String userName);

    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);

    List<Employee> findByUsernameContainingIgnoreCase(String keyword);


    Employee findByCheckInCode(String checkInCode);
}
