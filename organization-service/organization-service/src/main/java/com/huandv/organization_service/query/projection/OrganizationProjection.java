package com.huandv.organization_service.query.projection;

import com.huandv.organization_service.command.event.OrganizationCreateEvent;
import com.huandv.organization_service.entity.Organization;
import com.huandv.organization_service.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Project: microservice-spring-v3
 * @Date: 1/8/2025 2:28 PM
 * @Author: huan.dovan
 */
@Component
@RequiredArgsConstructor
public class OrganizationProjection {

  private final OrganizationRepository organizationRepository;

  @EventHandler
  public void on(OrganizationCreateEvent organizationCreateEvent) {
    Organization organization = new Organization();
    BeanUtils.copyProperties(organizationCreateEvent, organization);
    organizationRepository.save(organization);
  }

}
