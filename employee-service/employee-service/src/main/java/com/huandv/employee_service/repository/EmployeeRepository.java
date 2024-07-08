package com.huandv.employee_service.repository;

import com.huandv.employee_service.dto.EmployeeDto;
import com.huandv.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 10:51 AM
 * @Author: crist
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getEmployeeById(Long id);

}
