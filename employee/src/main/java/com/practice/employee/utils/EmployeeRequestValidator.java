package com.practice.employee.utils;
import com.practice.employee.request.EmployeeRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EmployeeRequestValidator {
    public void validateRequest(EmployeeRequest request){
        if(StringUtils.isBlank(request.getContactNumber())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact Number cannot be null or empty");
        }
        if(StringUtils.isBlank(request.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be null or empty");
        }
        if(StringUtils.isBlank(request.getDepartment())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department cannot be null or empty");
        }
        if(request.getSalary() == null || request.getSalary() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salary must be greater than zero");
        }
    }

    public void validateContactNumber(String contactNumber){
        if(StringUtils.isBlank(contactNumber)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact Number cannot be null or empty");
        }
    }
}
