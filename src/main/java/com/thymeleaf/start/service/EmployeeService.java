package com.thymeleaf.start.service;

import com.thymeleaf.start.repository.EmployeeRepository;
import com.thymeleaf.start.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save ( employee );
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll ();
    }

    public Optional<Employee> findById(Long id) {
       return employeeRepository.findById ( id );
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById ( id );
    }
}
