package com.example.Blog.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private long id;
    private String userName;
    private String email;

}
