package com.huandv.employee_service.config;

import com.huandv.employee_service.dto.DepartmentDto;
import com.huandv.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/3/2024 9:56 PM
 * @Author: crist
 */
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("/department/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

    @GetMapping("organization/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);

}
