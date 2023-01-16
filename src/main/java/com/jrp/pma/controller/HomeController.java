package com.jrp.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        // query the database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        List<ChartData> projectData = projectRepository.getProjectStatus();

        // convert projectData object into a JSON for use in JS
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
        model.addAttribute("projectStatusCount", jsonString);

        // query the database for employees
        List<EmployeeProject> employeesProjectCount = employeeRepository.getEmployeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);

        return "main/home";
    }
}
