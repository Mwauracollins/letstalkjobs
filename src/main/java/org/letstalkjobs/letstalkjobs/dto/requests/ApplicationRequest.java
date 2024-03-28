package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Application;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    private Application application;
}
