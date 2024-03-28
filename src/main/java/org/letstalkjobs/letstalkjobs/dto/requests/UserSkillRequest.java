package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSkillRequest {
    private String skillName;
    private BaseUser user;
}
