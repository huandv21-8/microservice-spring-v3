package com.huandv.organization_service.command.aggregate;

import com.huandv.organization_service.command.CreateOrganizationCommand;
import com.huandv.organization_service.command.event.OrganizationCreateEvent;
import com.huandv.organization_service.entity.Organization;
import com.huandv.organization_service.repository.OrganizationRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

/**
 * @Description:
 * @Project: microservice-spring-v3
 * @Date: 1/8/2025 10:35 AM
 * @Author: huan.dovan
 */
@Aggregate
public class OrganizationAggregate {

  @AggregateIdentifier
  private Long id;
  private String organizationName;
  private String organizationDescription;
  private String organizationCode;
  private LocalDateTime createdDate;

  public OrganizationAggregate() {
  }

  @CommandHandler
  public OrganizationAggregate(CreateOrganizationCommand createOrganizationCommand,
      OrganizationRepository organizationRepository) {

    Organization organization = organizationRepository.findByOrganizationCode(
        createOrganizationCommand.getOrganizationCode());

    if (Objects.nonNull(organization)){
      throw new RuntimeException();
    }
    OrganizationCreateEvent organizationCreateEvent = new OrganizationCreateEvent();
    BeanUtils.copyProperties(createOrganizationCommand, organizationCreateEvent);
    AggregateLifecycle.apply(organizationCreateEvent);

  }

  @EventSourcingHandler
  public void on(OrganizationCreateEvent organizationCreateEvent) {
    this.id = organizationCreateEvent.getId();
    this.createdDate = organizationCreateEvent.getCreatedDate();
    this.organizationName = organizationCreateEvent.getOrganizationName();
    this.organizationCode = organizationCreateEvent.getOrganizationCode();
    this.organizationDescription = organizationCreateEvent.getOrganizationDescription();
  }

}
