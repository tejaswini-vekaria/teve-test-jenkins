package com.thymeleaf.start.mapping;

import com.thymeleaf.start.dto.EmployeeDTO;
import com.thymeleaf.start.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapping {
    EmployeeMapping EMPLOYEE_MAPPING = Mappers.getMapper ( EmployeeMapping.class );

    EmployeeDTO toEmployee(Employee employee);

    Employee toEmployeeDto(EmployeeDTO employeeDTO);

    List<Employee> listEmployee(List<EmployeeDTO> employeeDTOList);

    List<EmployeeDTO> listDto(List<Employee> employeeList);
}
