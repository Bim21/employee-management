package com.ncc.repository;

import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByName(String name);

    public boolean existsByName(String name);

    public void deleteById(int id);
}
