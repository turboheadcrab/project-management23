package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    final
    ProjectRepository projectRepository;

    final
    EmployeeRepository employeeRepository;

    public HomeController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model) {
        // query the database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        // query the database for employees
        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);

        return "main/home";
    }
}
