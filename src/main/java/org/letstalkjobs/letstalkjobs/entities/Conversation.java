package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer conversationId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Chat> chats;
    @ManyToOne
    private BaseUser sender;
    @ManyToOne
    private BaseUser recipient;
}
