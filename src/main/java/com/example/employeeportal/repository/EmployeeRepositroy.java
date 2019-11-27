package com.example.employeeportal.repository;

import com.example.employeeportal.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepositroy extends CrudRepository<Employee, Integer> {

    String sql1 = "select * from Employee order by first_name ASC";
    @Query(value = sql1, nativeQuery = true)
    public List<Employee> findAllEmployee();

}
