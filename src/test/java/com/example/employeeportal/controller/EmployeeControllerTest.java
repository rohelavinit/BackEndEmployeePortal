package com.example.employeeportal.controller;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

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
    void saveEmployee() throws Exception {

        given(this.employeeService.saveEmployee(employee)).willReturn(employee);

        this.mvc.perform(MockMvcRequestBuilders.post("/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"dateOfBirth\": \"2019\",\n" +
                        "  \"department\": \"abcd\",\n" +
                        "  \"firstName\": \"boy\",\n" +
                        "  \"gender\": \"string\",\n" +
                        "  \"id\": 0,\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"version\": 0\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void findAllEmployee() throws Exception {

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

        given(this.employeeService.findAllEmployee()).willReturn(employeeList);

        this.mvc.perform(MockMvcRequestBuilders.get("/findAllEmployee")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}