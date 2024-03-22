package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.util.Date;
/*
This entity record the chat meta data like is it viewed.
 */

@Data
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;
    @Column(name = "is_viewed")
    private Boolean isViewed;
    @Column(name = "is_delivered")
    private Boolean isDelivered;
    @Column(name = "send_date")
    private Date sendDate;
    @OneToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;



    public Notification() {
    }
}
