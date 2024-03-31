package org.letstalkjobs.letstalkjobs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformationResponse {
    //TODO: Add more fields
    private BaseUser user;
    private String email;
}
