package com.practice.employee.service;

import com.practice.employee.entity.Employee;
import com.practice.employee.repository.EmployeeRepository;
import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.BaseResponse;
import com.practice.employee.response.EmployeeResponse;
import com.practice.employee.utils.EmployeeRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeRequestValidator validator;

    @Override
    public BaseResponse createEmployee(EmployeeRequest request) {
        validator.validateRequest(request);
        Optional<Employee> employeeOpt = repository.findByContactNumber(request.getContactNumber().trim());
        if (employeeOpt.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee already exists for the given contact number");
        }
        Employee employee = new Employee();
        employee.setName(request.getName().trim());
        employee.setDepartment(request.getDepartment().trim());
        employee.setSalary(request.getSalary());
        employee.setContactNumber(request.getContactNumber().trim());
        try {
            repository.save(employee);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Not able to save employee data in DB with exception: " + ex.getMessage());
        }
        return successResponse("Employee created successfully");
    }

    @Override
    public EmployeeResponse getEmployeeById(String contactNumber) {
        validator.validateContactNumber(contactNumber);
        Optional<Employee> employeeOpt = repository.findByContactNumber(contactNumber.trim());
        EmployeeResponse response = new EmployeeResponse();
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            response.setName(employee.getName());
            response.setDepartment(employee.getDepartment());
            response.setSalary(employee.getSalary());
            response.setContactNumber(employee.getContactNumber());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for the given contact number");
        }
        return response;
    }
    @Override
    public BaseResponse updateEmployee(EmployeeRequest request){
        validator.validateRequest(request);
        Optional<Employee> employeeOpt = repository.findByContactNumber(request.getContactNumber().trim());
        if (employeeOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for the given contact number");
        }
        Employee employee = employeeOpt.get();
        employee.setName(request.getName().trim());
        employee.setDepartment(request.getDepartment().trim());
        employee.setSalary(request.getSalary());
        try {
            repository.save(employee);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Not able to update employee data in DB with exception: " + ex.getMessage());
        }
        return successResponse("Employee updated successfully");
    }

    public BaseResponse deleteEmployee(String contactNumber){
        validator.validateContactNumber(contactNumber);
        Optional<Employee> employeeOpt = repository.findByContactNumber(contactNumber.trim());
        if (employeeOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found for the given contact number");
        }
        try {
            repository.delete(employeeOpt.get());
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Not able to delete employee data in DB with exception: " + ex.getMessage());
        }
        return successResponse("Employee deleted successfully");
    }

    private BaseResponse successResponse(String message) {
        BaseResponse response = new BaseResponse();
        response.setStatuesCode(1);
        response.setMessage(message);
        return response;
    }
}
