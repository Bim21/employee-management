package com.ncc.repository;

import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

<<<<<<< HEAD
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByUserName(String userName);

    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);

    List<Employee> findByUsernameContainingIgnoreCase(String keyword);
=======
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByLastName(String lastName);

    public boolean existsByLastName(String lastName);

    public void deleteById(int id);

>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
}
