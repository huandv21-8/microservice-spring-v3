package com.huandv.department_service.service.imp;

import com.huandv.department_service.dto.DepartmentDto;
import com.huandv.department_service.entity.Department;
import com.huandv.department_service.repository.DepartmentRepository;
import com.huandv.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 9:37 AM
 * @Author: crist
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());


        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto response = modelMapper.map(saveDepartment, DepartmentDto.class);
        return response;
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        List<Department> department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto response = modelMapper.map(department.get(0), DepartmentDto.class);
        return response;
    }
}
