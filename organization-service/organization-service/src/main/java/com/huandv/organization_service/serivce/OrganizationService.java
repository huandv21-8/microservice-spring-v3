package com.huandv.organization_service.serivce;

import com.huandv.organization_service.dto.OrganizationDto;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/9/2024 12:48 AM
 * @Author: crist
 */
public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);
}
