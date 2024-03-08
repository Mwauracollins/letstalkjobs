package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.jobentities.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {
    JobCategory findByName(String name);

    @Override
    List<JobCategory> findAll();
}
