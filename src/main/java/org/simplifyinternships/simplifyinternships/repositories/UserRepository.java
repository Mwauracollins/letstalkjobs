package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Integer> {
    BaseUser findByEmail(String email);
//    @Query("SELECT u FROM BASEUSER u WHERE users.email <> ?1 AND (users.userRole is "MENTOR" OR users .userRole )")

    @Override
    List<BaseUser> findAll();
}
