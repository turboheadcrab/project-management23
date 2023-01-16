package com.jrp.pma.dao;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(
            nativeQuery = true,
            value = "SELECT stage AS label, COUNT(*) AS amount " +
                    "FROM project " +
                    "GROUP BY stage"
    )
    List<ChartData> getProjectStatus();
}
