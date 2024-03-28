package org.letstalkjobs.letstalkjobs.repositories;

import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

    @Override
    Optional<Attachment> findById(@NotNull Integer integer);

    @Override
    List<Attachment> findAll();
}
