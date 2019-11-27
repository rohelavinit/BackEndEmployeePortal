package com.example.employeeportal.service;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.repository.EmployeeRepositroy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepositroy employeeRepositroy;

    private Employee employee = new Employee();

    @BeforeEach
    void setUp() {
        employee.setId(1);
        employee.setVersion(0);
        employee.setFirstName("Ram");
        employee.setLastName("kumar");
        employee.setGender("male");
        employee.setDateOfBirth("15-03-1994");
        employee.setDepartment("Compozed");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveEmployee() {

        when(employeeRepositroy.save(Mockito.any())).thenReturn(employee);

        Employee employeeResult = employeeService.saveEmployee(employee);
        assertNotNull(employeeResult);
        assertEquals("Ram",employeeResult.getFirstName());
    }

    @Test
    void findAllEmployee() {

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setVersion(0);
        employee2.setFirstName("vinit");
        employee2.setLastName("kumar");
        employee2.setGender("male");
        employee2.setDateOfBirth("15-03-1994");
        employee2.setDepartment("Compozed");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);

        when(employeeRepositroy.findAllEmployee()).thenReturn(employeeList);

        List<Employee> employeeResult = employeeService.findAllEmployee();
        assertNotNull(employeeResult);
        assertEquals("Ram",employeeResult.get(0).getFirstName());
    }
}