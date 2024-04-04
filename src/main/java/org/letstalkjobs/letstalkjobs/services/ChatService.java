package org.letstalkjobs.letstalkjobs.services;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.dto.requests.ChatRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.ChatResponse;
import org.letstalkjobs.letstalkjobs.entities.Chat;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.repositories.ChatRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ConversationService conversationService;

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

    public ChatResponse sendMessage(ChatRequest request) {
        Chat chat = Chat.builder()
                .message(request.getMessage())
                .build();
        chatRepository.save(chat);
        return ChatResponse.builder()
                .message(chat.getMessage())
                .build();

    }
}
