package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/*
This entity record the chat meta data like is it viewed.
 */

@Entity
@Table(name = "notification")
public class Notification {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;
    @Getter
    @Setter
    @Column(name = "is_viewed")
    private Boolean isViewed;
    @Getter
    @Setter
    @Column(name = "is_delivered")
    private Boolean isDelivered;
    @Getter
    @Setter
    @Column(name = "send_date")
    private Date sendDate;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;



    public Notification() {
    }
}
