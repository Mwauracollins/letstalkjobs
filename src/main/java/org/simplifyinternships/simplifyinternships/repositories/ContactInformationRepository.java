package org.simplifyinternships.simplifyinternships.repositories;

import org.simplifyinternships.simplifyinternships.entities.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Integer> {

    ContactInformation findByEmail(String email);
    ContactInformation findByPhoneNumber(String phoneNumber);
    ContactInformation findByWebsite(String website);
    @Override
    List<ContactInformation> findAll();
}
