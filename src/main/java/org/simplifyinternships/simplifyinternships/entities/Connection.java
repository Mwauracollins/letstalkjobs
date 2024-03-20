package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.*;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

/*
Represents the relationship between two users
 */
@Builder
@Entity
@Table(name = "connection")
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Integer connectionId;
    @Getter
    @Setter
    @ManyToOne
    private BaseUser user1;
    @Getter
    @Setter
    @ManyToOne
    private BaseUser user2;
    @Getter
    @Setter
    @Column(name = "is_pending")
    private Boolean isPending;

}
