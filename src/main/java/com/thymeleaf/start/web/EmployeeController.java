package com.thymeleaf.start.web;

import com.thymeleaf.start.dto.EmployeeDTO;
import com.thymeleaf.start.entity.Employee;
import com.thymeleaf.start.mapping.EmployeeMapping;
import com.thymeleaf.start.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView ( "home" );
        List<Employee> employeeList = employeeService.findAll ( );
        List<EmployeeDTO> list = EmployeeMapping.EMPLOYEE_MAPPING.listDto ( employeeList );
        modelAndView.addObject ( "employees", list );
        return modelAndView;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployee() {
        ModelAndView modelAndView = new ModelAndView ( "add-employee-form" );
        EmployeeDTO employeeDTO = new EmployeeDTO ( );
        Employee newEmployee = EmployeeMapping.EMPLOYEE_MAPPING.toEmployeeDto ( employeeDTO );
        modelAndView.addObject ( "employee", newEmployee );
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public void saveEmployees(@ModelAttribute EmployeeDTO employeeDTO, HttpServletResponse response) throws IOException {
        Employee employee = EmployeeMapping.EMPLOYEE_MAPPING.toEmployeeDto ( employeeDTO );
        employeeService.save ( employee );
        response.sendRedirect ( "/list" );
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForms(@RequestParam Long employeeId) {
        ModelAndView modelAndView = new ModelAndView ( "add-employee-form" );
        Employee employee = employeeService.findById ( employeeId ).get ( );
        EmployeeDTO employeeDTO = EmployeeMapping.EMPLOYEE_MAPPING.toEmployee ( employee );
        modelAndView.addObject ( "employee", employeeDTO );
        return modelAndView;
    }

    @GetMapping("/deleteEmployee")
    public void deleteEmployees(@RequestParam Long employeeId, HttpServletResponse response) throws IOException {
        employeeService.deleteById ( employeeId );
        response.sendRedirect ( "list" );
    }
}
