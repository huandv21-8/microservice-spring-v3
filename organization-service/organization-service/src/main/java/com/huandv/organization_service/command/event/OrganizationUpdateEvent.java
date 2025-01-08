package com.huandv.organization_service.command.event;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @Description:
 * @Project: microservice-spring-v3
 * @Date: 1/8/2025 9:09 AM
 * @Author: huan.dovan
 */
@Data
public class OrganizationUpdateEvent {

  private Long id;
  private String organizationName;
  private String organizationDescription;
  private String organizationCode;
  private LocalDateTime createdDate;

}
