package com.example.Blog.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id // unikalna kolumna w bazie danych(id+1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;


    @Embedded
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<PostComment> comments = new HashSet<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name="userId")
    @Getter
    @Setter
    private User user;

    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);


    }
}