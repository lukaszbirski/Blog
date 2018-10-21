package com.example.Blog.configure;

import com.example.Blog.model.dto.PostDTO;
import com.example.Blog.model.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class BasicConguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(pst -> pst.getUser().getId(),PostDTO::setIdOfUser)
                .addMapping(p -> p.getAudit().getAdded(), PostDTO::setCreated);
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
