package com.huandv.organization_service.serivce.imp;

import com.huandv.organization_service.dto.OrganizationDto;
import com.huandv.organization_service.entity.Organization;
import com.huandv.organization_service.repository.OrganizationRepository;
import com.huandv.organization_service.serivce.OrganizationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/9/2024 12:48 AM
 * @Author: crist
 */
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final ModelMapper modelMapper;
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto, Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return  modelMapper.map(savedOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
