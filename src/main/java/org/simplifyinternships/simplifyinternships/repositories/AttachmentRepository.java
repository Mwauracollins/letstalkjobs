package org.simplifyinternships.simplifyinternships.repositories;

import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

    @Override
    Optional<Attachment> findById(@NotNull Integer integer);

    @Override
    List<Attachment> findAll();
}
