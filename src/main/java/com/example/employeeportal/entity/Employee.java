package com.example.employeeportal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    private int id;
    private int version;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String department;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    @NotNull
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    @NotNull
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    @NotNull
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    @NotNull
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
}
