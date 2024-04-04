package org.letstalkjobs.letstalkjobs.entities.postentities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "content")
    private String content;
    @Column(name = "post_date")
    private String postDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;
    @OneToMany(mappedBy = "post")
    private List<PostReaction> postReactions;


}
