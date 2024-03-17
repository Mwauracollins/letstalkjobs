package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.simplifyinternships.simplifyinternships.Utils.TokenType;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

@Builder
@Entity
@Table(name = "token")
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Integer tokenId;
    @Column(unique = true)
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private BaseUser user;

}
