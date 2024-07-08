package com.huandv.employee_service.service;

import com.huandv.employee_service.dto.ApiResponseDto;
import com.huandv.employee_service.dto.EmployeeDto;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 10:50 AM
 * @Author: crist
 */
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployee(Long id);
}
