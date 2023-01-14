package com.jrp.pma.controller;

import com.jrp.pma.dao.ProjectRepository;
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

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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

        model.addAttribute("project", aProject);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project) {
        projectRepository.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
