package org.simplifyinternships.simplifyinternships.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformationRequest {
    //TODO: Add more fields
    private String email;
    private String phoneNumber;
    private String website;
}
