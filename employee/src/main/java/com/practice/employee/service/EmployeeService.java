package com.practice.employee.service;

import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.BaseResponse;
import com.practice.employee.response.EmployeeResponse;

public interface EmployeeService {
    BaseResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(String contactNumber);
    BaseResponse updateEmployee(EmployeeRequest request);
    BaseResponse deleteEmployee(String contactNumber);
}
