package org.letstalkjobs.letstalkjobs.controllers;

import org.letstalkjobs.letstalkjobs.entities.ContactInformation;
import org.letstalkjobs.letstalkjobs.services.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact_information")
public class ContactInformationController {
    private final ContactInformationService contactInformationService;

    @Autowired
    public ContactInformationController(ContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }
    @GetMapping
    public List<ContactInformation> getAllContactInformation(){
        return contactInformationService.getAllContactInformation();
    }
    @PostMapping
    public ContactInformation addContactInformation(@RequestBody ContactInformation contactInformation){
        return contactInformationService.addContactInformation(contactInformation);
    }
}
