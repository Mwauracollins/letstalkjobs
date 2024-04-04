package org.letstalkjobs.letstalkjobs.repositories;

import org.letstalkjobs.letstalkjobs.Utils.JobType;
import org.letstalkjobs.letstalkjobs.entities.Company;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobCategory;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobOpportunity, Integer> {
    Optional<JobOpportunity> findByJobType(JobType jobType);
    Optional<JobOpportunity> findByCategory(JobCategory category);
    Optional<JobOpportunity> findByCompany(Company company);
    Optional<JobOpportunity> findByPosition(Position position);
    Optional<JobOpportunity> findByName(String name);
    Optional<JobOpportunity> findByStartDate(Date startDate);
    Optional<JobOpportunity> findByDatePosted(Date datePosted);

    @Override
    List<JobOpportunity> findAll();
}
