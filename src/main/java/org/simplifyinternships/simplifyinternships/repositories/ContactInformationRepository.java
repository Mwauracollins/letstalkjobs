package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.ContactInformation;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Integer> {
    ContactInformation findByUser(BaseUser user);

    ContactInformation findByEmail(String email);
    ContactInformation findByPhoneNumber(String phoneNumber);
    ContactInformation findByWebsite(String website);
    @Override
    List<ContactInformation> findAll();
}
