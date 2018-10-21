package com.example.Blog.controllers;

import com.example.Blog.model.entities.Post;
import com.example.Blog.model.entities.PostComment;
import com.example.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String postPage(Model model){
        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable){
            postList.add(post);
        }
        model.addAttribute("posts", postList);

        return "posts";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam(value = "title") String titleParam, @RequestParam(value = "content") String content, Model model){

        Post post = new Post(titleParam, content);
        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);

        post.addComment(postComment);
        postRepository.save(post);

        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post singlePost : postIterable){
            postList.add(singlePost);
        }
        model.addAttribute("posts", postList);

        return "posts";
    }

    @GetMapping("/addPost")
    public String addPost(){
        return "addPost";
    }
}
