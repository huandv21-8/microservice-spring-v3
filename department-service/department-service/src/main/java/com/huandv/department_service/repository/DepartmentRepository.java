package com.huandv.department_service.repository;

import com.huandv.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 9:35 AM
 * @Author: crist
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentCode(String departmentCode);
}
