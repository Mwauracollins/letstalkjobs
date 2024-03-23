package org.simplifyinternships.simplifyinternships.services;

import lombok.RequiredArgsConstructor;
import org.simplifyinternships.simplifyinternships.dto.responses.ChatResponse;
import org.simplifyinternships.simplifyinternships.entities.Chat;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.repositories.ChatRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public List<ChatResponse>  getUserConversations(
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (user == null){
            throw new IllegalStateException("Login to access messages");
//            return Collections.emptyList();
        }

        return chatRepository.findBySenderAndReceiver(user, user)
                .stream()
                .map(chat -> ChatResponse.builder()
                        .build())
                .toList();

    }
}
