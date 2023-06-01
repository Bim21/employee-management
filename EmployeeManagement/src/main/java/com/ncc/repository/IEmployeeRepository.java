package com.ncc.repository;

<<<<<<< HEAD
public interface IEmployeeRepository {

}
=======
import com.ncc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    public Employee findByLastName(String lastName);

    public boolean existsByLastName(String lastName);

    public void deleteById(int id);

}
>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
