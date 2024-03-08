package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

/*
Represents the relationship between two users
 */
@Entity
@Table(name = "connection")
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

    public Connection(){

    }

}
