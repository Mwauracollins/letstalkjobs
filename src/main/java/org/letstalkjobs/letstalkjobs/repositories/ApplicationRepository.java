package org.letstalkjobs.letstalkjobs.repositories;


import org.letstalkjobs.letstalkjobs.Utils.ApplicationStatus;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Application;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Optional<Application> findByApplicant(Applicant applicant);
    Optional<Application> findByApplicationStatus(ApplicationStatus applicationStatus);

    @Override
    Optional<Application> findById(Integer integer);

    @Override
    List<Application> findAll();
}
