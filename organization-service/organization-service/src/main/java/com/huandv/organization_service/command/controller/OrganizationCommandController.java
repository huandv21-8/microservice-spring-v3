package com.huandv.organization_service.command.controller;

import com.huandv.organization_service.command.CreateOrganizationCommand;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Project: microservice-spring-v3
 * @Date: 1/8/2025 9:20 AM
 * @Author: huan.dovan
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrganizationCommandController {

  private final CommandGateway commandGateway;

  @PostMapping("/create-organization")
  public void createOrganization() {

    CreateOrganizationCommand createOrganizationCommand = CreateOrganizationCommand.builder()
        .id(Long.parseLong(UUID.randomUUID().toString()))
        .organizationName("abc")
        .organizationCode("1")
        .organizationDescription("")
        .createdDate(LocalDateTime.now())
        .build();

    commandGateway.sendAndWait(createOrganizationCommand);
    System.out.println("create success");
  }

}
