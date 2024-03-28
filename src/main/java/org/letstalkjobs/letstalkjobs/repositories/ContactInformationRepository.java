package org.letstalkjobs.letstalkjobs.repositories;

import org.letstalkjobs.letstalkjobs.entities.ContactInformation;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Integer> {
    ContactInformation findByUser(BaseUser user);

    ContactInformation findByEmail(String email);
    ContactInformation findByPhoneNumber(String phoneNumber);
    ContactInformation findByWebsite(String website);
    @Override
    List<ContactInformation> findAll();
}
