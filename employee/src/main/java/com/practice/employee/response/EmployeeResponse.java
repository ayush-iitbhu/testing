package com.practice.employee.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse{
    private Long id;
    private String name;
    private String department;
    private Double salary;
    private String contactNumber;
}
