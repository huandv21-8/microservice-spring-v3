package com.huandv.employee_service.service.imp;

import com.huandv.employee_service.config.ApiClient;
import com.huandv.employee_service.dto.ApiResponseDto;
import com.huandv.employee_service.dto.DepartmentDto;
import com.huandv.employee_service.dto.EmployeeDto;
import com.huandv.employee_service.dto.OrganizationDto;
import com.huandv.employee_service.entity.Employee;
import com.huandv.employee_service.repository.EmployeeRepository;
import com.huandv.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/2/2024 10:51 AM
 * @Author: crist
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final ApiClient client;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode());

        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto response = modelMapper.map(saveEmployee, EmployeeDto.class);

        return response;
    }

    @Override
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultMethod")
    public ApiResponseDto getEmployee(Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);

        DepartmentDto department = client.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        OrganizationDto organizationDto = client.getOrganization(employee.getOrganizationCode());

        ApiResponseDto response= new ApiResponseDto(department,employeeDto,organizationDto);
        return response;
    }

    public ApiResponseDto getDefaultMethod(Long id, Exception exception) {
        DepartmentDto department = new DepartmentDto(id,"default","default","default");
        EmployeeDto employee = new EmployeeDto(id,"default","default","default","default","default");
       OrganizationDto organizationDto = new OrganizationDto(id,"default","default","default", LocalDateTime.now());
        ApiResponseDto response= new ApiResponseDto(department,employee,organizationDto);
        return response;

    }
}
