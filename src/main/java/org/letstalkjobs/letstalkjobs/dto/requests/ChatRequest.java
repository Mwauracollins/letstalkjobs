package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    private BaseUser sender;
    private BaseUser recipient;
    private String message;
}
