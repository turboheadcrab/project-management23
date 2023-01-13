package com.jrp.pma.controller;

import com.jrp.pma.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();

        model.addAttribute("project", aProject);

        return "new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project, Model model) {
        // TODO: this should handle saving to the database...
        return "";
    }
}
