package com.huandv.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/3/2024 11:49 PM
 * @Author: crist
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
    private OrganizationDto organizationDto;
}
