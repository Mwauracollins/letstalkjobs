package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.UserSkill;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
    Optional<UserSkill> findByUser(BaseUser user);
    @Override
    Optional<UserSkill> findById(Integer integer);

    @Override
    List<UserSkill> findAll();
}
