package com.example.Blog.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@NoArgsConstructor
@Embeddable
public class AuditEntity {

    private Date added = new Date();
    private String addedBy;
    private Date modified;
    private String modifiedBy;

}
