package org.letstalkjobs.letstalkjobs.repositories;

import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.entities.Education;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
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
