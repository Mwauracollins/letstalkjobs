package org.letstalkjobs.letstalkjobs.services;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.dto.responses.ChatResponse;
import org.letstalkjobs.letstalkjobs.dto.responses.ConversationResponse;
import org.letstalkjobs.letstalkjobs.entities.Conversation;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public Optional<ConversationResponse> getConversation(
            BaseUser sender,
            BaseUser recipient,
            boolean createNewConversationIfNotExists
    ) {
        Optional<Conversation> conversationOptional = conversationRepository.findBySenderAndRecipient(sender, recipient);
        if (conversationOptional.isPresent()) {
                return conversationOptional.map(conversation -> {
                List<ChatResponse> chatResponses = conversation.getChats().stream()
                        .map(chat -> ChatResponse.builder()
                                //TODO: Map other fields
                                .message(chat.getMessage())
                                .build()
                        )
                        .collect(Collectors.toList());
                return ConversationResponse.builder()
                        .conversationId(conversation.getConversationId())
                        .chats(chatResponses)
                        .build();
            });
        } else if (createNewConversationIfNotExists) {
            Conversation newConversation = new Conversation();
            newConversation.setSender(sender);
            newConversation.setRecipient(recipient);

            Conversation savedConversation = conversationRepository.save(newConversation);

            return Optional.of(ConversationResponse.builder()
                            .conversationId(savedConversation.getConversationId())
                            .chats(List.of())
                    .build());
        }else {
            return Optional.empty();
        }
    }
}
