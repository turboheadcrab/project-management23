package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    final
    EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employeeList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee anEmployee = new Employee();

        model.addAttribute("employee", anEmployee);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);

        return "redirect:/employees/new";
    }
}
