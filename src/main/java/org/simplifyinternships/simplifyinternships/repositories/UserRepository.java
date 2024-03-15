package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Integer> {
    Optional<BaseUser> findByEmail(String email);
//    @Query("SELECT u FROM BASEUSER u WHERE users.email <> ?1 AND (users.userRole is "MENTOR" OR users .userRole )")
    BaseUser findByUsername(String userName);
    List<BaseUser> findByFirstName(String firstName);
    List<BaseUser> findByLastName(String lastName);
//    List<BaseUser> findByUsernameAndUserRole(String userName, String userRole);
    @Override
    List<BaseUser> findAll();
}
