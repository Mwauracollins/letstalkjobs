package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

/*
Represents the relationship between two users
 */
@Data
@Builder
@Entity
@Table(name = "connection")
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Integer connectionId;
    @ManyToOne
    private BaseUser user1;
    @ManyToOne
    private BaseUser user2;
    @Column(name = "is_pending")
    private Boolean isPending;

}
