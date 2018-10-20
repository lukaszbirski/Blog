package com.example.Blog.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String comment;

    @Embedded
    private AuditEntity auditEntity = new AuditEntity();

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
}
