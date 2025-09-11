package com.practice.employee.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private String department;
    private Double salary;
    private String contactNumber;
}
