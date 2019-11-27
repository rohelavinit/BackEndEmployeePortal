package com.example.employeeportal.service;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.repository.EmployeeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepositroy employeeRepositroy;

    public Employee saveEmployee(Employee employee){
        return employeeRepositroy.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepositroy.findAllEmployee();
    }
}
