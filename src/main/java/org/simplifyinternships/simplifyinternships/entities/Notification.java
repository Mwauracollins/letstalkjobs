package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
    @Column(name = "notification_date")
    private Date notificationDate;

    public Notification() {
    }
}
