package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

@Data
@Entity
@Table(name = "chat")
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Document
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer chatId;
    @Column(name = "message")
    private String message;
    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private BaseUser sender;
    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private BaseUser receiver;
    @OneToOne(mappedBy = "chat", cascade = CascadeType.ALL)
    private Notification chatMeta;

}
