package com.huandv.department_service.service;

import com.huandv.department_service.dto.DepartmentDto;
import com.huandv.department_service.entity.Department;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 9:45 AM
 * @Author: crist
 */
public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartment(String departmentCode);
}
