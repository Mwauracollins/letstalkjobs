package org.letstalkjobs.letstalkjobs.controllers;
//
import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.dto.requests.ChatRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.ChatResponse;
import org.letstalkjobs.letstalkjobs.dto.responses.ConversationResponse;
import org.letstalkjobs.letstalkjobs.entities.Chat;
import org.letstalkjobs.letstalkjobs.entities.Conversation;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.services.ChatService;
import org.letstalkjobs.letstalkjobs.services.ConversationService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final ConversationService conversationService;
    private final ChatService chatService;
    @MessageMapping("/conversation.get")
    @SendToUser
    public ConversationResponse getConversation(Principal connectedUser){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        Optional<ConversationResponse> conversationOptional = conversationService.getConversation(user, null, false);
        return conversationOptional
                .orElse(null);
    }
    @MessageMapping("/conversation.getWith")
    @SendToUser
    public ConversationResponse getConversationWith(
            Principal connectedUser,
            @RequestBody Principal recipientUser
    ) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var recipient = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        Optional<ConversationResponse> conversationOptional = conversationService.getConversation(user, recipient, true);
        return conversationOptional
                .orElse(null);
    }
    @MessageMapping("/chat/send")
    @SendTo("/topic/conversation/{chatId}")
    public ChatResponse sendMessage(
            @RequestBody ChatRequest request
    ){
        return chatService.sendMessage(request);
    }
}
