package org.simplifyinternships.simplifyinternships.repositories;

import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.entities.Chat;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
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
