package com.jrp.pma.dao;

import com.jrp.pma.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
        projectRepository.save(newProject);

        assertEquals(1, projectRepository.findAll().size());
    }
}
