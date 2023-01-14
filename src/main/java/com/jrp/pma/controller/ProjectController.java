package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entity.Employee;
import com.jrp.pma.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    final
    ProjectRepository projectRepository;

    final
    EmployeeRepository employeeRepository;

    public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectList", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project) {
        projectRepository.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects";
    }
}
