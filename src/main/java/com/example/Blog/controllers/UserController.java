package com.example.Blog.controllers;

import com.example.Blog.repositories.UserRepository;
import com.example.Blog.services.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    private UserSessionService userSessionService;
    @Autowired
    private ModelMapper modelMapper;
    //private UserController (UserRepository);


    public UserController(UserRepository userRepository, UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }
}
