package com.huandv.organization_service.command;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @Description:
 * @Project: microservice-spring-v3
 * @Date: 1/7/2025 11:20 AM
 * @Author: huan.dovan
 */

@Data
@Builder
public class CreateOrganizationCommand {

 @TargetAggregateIdentifier
 private final Long id;
 private final String organizationName;
 private final String organizationDescription;
 private final String organizationCode;
 private final LocalDateTime createdDate;

}
