package com.huandv.employee_service.controller;

import com.huandv.employee_service.dto.ApiResponseDto;
import com.huandv.employee_service.dto.EmployeeDto;
import com.huandv.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 10:52 AM
 * @Author: crist
 */
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto response = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable Long id){
        ApiResponseDto response = employeeService.getEmployee(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
