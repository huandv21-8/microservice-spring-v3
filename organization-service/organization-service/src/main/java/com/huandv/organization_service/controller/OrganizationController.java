package com.huandv.organization_service.controller;
import com.huandv.organization_service.dto.OrganizationDto;
import com.huandv.organization_service.serivce.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/9/2024 12:44 AM
 * @Author: crist
 */
@RestController
@RequestMapping("/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}
