package org.letstalkjobs.letstalkjobs.repositories;

import org.letstalkjobs.letstalkjobs.entities.jobentities.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {
    JobCategory findByName(String name);

    @Override
    List<JobCategory> findAll();
}
