package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
public class Post {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;
    @Getter
    @Setter
    @Column(name = "content")
    private String content;
    @Getter
    @Setter
    @Column(name = "post_date")
    private String postDate;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;

    public Post() {
    }

}
