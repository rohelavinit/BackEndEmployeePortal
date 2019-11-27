package com.example.employeeportal.controller;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllEmployee")
    public List<Employee> findAllEmployee() {
        return (List<Employee>) employeeService.findAllEmployee();
    }
}
