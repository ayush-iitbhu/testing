package com.practice.employee.exception;

import com.practice.employee.response.BaseResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseResponse> handleResponseStatusException(ResponseStatusException ex) {
        BaseResponse response = new BaseResponse();
        response.setStatuesCode(0);
        response.setMessage(ex.getReason());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }
}
