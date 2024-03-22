package org.simplifyinternships.simplifyinternships.repositories;

import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {
    @Override
    List<Internship> findAll();

    @Override
    Optional<Internship> findById(@NotNull Integer integer);
}
