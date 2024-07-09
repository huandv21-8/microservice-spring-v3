package com.huandv.employee_service.config;

import com.huandv.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/9/2024 9:26 AM
 * @Author: crist
 */
@FeignClient(name = "Organization-SERVICE")
public interface ApiClientOrganization {
    @GetMapping("organizations/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);

}
