package com.practice.employee.controller;

import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.BaseResponse;
import com.practice.employee.response.EmployeeResponse;
import com.practice.employee.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createEmployee(@RequestBody @NonNull EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse getEmployee(@RequestParam String contactNumber) {
       return employeeService.getEmployeeById(contactNumber);
    }

   @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateEmployee(@RequestBody @NonNull EmployeeRequest request) {
        return employeeService.updateEmployee(request);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse deleteEmployee(@RequestParam String contactNumber) {
        return employeeService.deleteEmployee(contactNumber);
    }

}
