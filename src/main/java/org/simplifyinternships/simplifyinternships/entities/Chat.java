package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

@Entity
@Table(name = "chat")
public class Chat {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer chatId;
    @Getter
    @Setter
    @Column(name = "message")
    private String message;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private BaseUser sender;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private BaseUser receiver;
    @Getter
    @Setter
    @OneToOne(mappedBy = "chat", cascade = CascadeType.ALL)
    private Notification chatMeta;


    public Chat() {
    }
}
