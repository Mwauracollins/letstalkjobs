package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.entities.ContactInformation;
import org.simplifyinternships.simplifyinternships.repositories.ContactInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInformationService {
    private final ContactInformationRepository contactInformationRepository;

    @Autowired
    public ContactInformationService(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }
    public List<ContactInformation> getAllContactInformation(){
        return contactInformationRepository.findAll();
    }
    public ContactInformation addContactInformation(ContactInformation contactInformation){
        return contactInformationRepository.save(contactInformation);
    }
}
