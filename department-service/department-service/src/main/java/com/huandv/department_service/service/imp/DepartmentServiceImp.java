package com.huandv.department_service.service.imp;

import com.huandv.department_service.dto.DepartmentDto;
import com.huandv.department_service.entity.Department;
import com.huandv.department_service.repository.DepartmentRepository;
import com.huandv.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: DepartmentServiceImp
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 9:37 AM
 * @Author: crist
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    private final Environment environment;

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());


        Department saveDepartment = departmentRepository.save(department);

      return modelMapper.map(saveDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        List<Department> department = departmentRepository.findByDepartmentCode(departmentCode);
        System.out.println("post using: " + environment.getProperty("local.server.port"));
      return modelMapper.map(department.get(0), DepartmentDto.class);
    }
}
