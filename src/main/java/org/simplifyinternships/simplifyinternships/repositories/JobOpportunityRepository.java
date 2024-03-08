package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.Company;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobCategory;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobType;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobOpportunity, Integer> {
    List<JobOpportunity> findByJobType(JobType jobType);
    List<JobOpportunity> findByCategory(JobCategory category);
    List<JobOpportunity> findByCompany(Company company);
    List<JobOpportunity> findByPosition(Position position);
    List<JobOpportunity> findByName(String name);
    List<JobOpportunity> findByStartDate(Date startDate);
    @Override
    List<JobOpportunity> findAll();
}
