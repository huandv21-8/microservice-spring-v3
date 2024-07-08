package com.huandv.department_service.controller;

import com.huandv.department_service.dto.DepartmentDto;
import com.huandv.department_service.entity.Department;
import com.huandv.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 9:47 AM
 * @Author: crist
 */
@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartment(departmentCode), HttpStatus.OK);

    }
}
