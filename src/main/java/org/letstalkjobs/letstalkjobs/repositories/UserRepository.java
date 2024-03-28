package org.letstalkjobs.letstalkjobs.repositories;

import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Integer> {
    Optional<BaseUser> findByEmail(String email);
    List<BaseUser> findByFirstName(String firstName);
    List<BaseUser> findByLastName(String lastName);
//    List<BaseUser> findByUsernameAndUserRole(String userName, String userRole);
    @Override
    List<BaseUser> findAll();
}
