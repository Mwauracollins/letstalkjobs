package org.letstalkjobs.letstalkjobs.repositories;

import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.entities.Chat;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Optional<Chat> findBySenderAndReceiver(BaseUser sender, BaseUser receiver);
    Optional<Chat> findBySender(BaseUser sender);
    Optional<Chat> findByReceiver(BaseUser receiver);
    @Override
    Optional<Chat> findById(@NotNull Integer integer);

    @Override
    List<Chat> findAll();
}
