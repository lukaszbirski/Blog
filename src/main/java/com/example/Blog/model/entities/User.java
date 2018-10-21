package com.example.Blog.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String email;
    private String password;

    @Embedded
    private AuditEntity auditEntity = new AuditEntity();

}
