package org.simplifyinternships.simplifyinternships.repositories;

import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.entities.Education;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    Optional<Education> findByUser(BaseUser user);
    @Override
    Optional<Education> findById(@NotNull Integer integer);

    @Override
    List<Education> findAll();
}
