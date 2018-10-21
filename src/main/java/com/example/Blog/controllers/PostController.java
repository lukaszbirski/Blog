package com.example.Blog.controllers;

import com.example.Blog.model.entities.Post;
import com.example.Blog.model.entities.PostComment;
import com.example.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String findPost(@PathVariable long id, ModelMap modelMap){

        Optional<Post> postOptional = postRepository.findById(id);
        postOptional.ifPresent(post -> {
            modelMap.addAttribute("post", post);
        });

        return "post";
    }

    @GetMapping("/removeposts/{id}")
    public String removePost(@PathVariable long id, ModelMap modelMap){

        postRepository.deleteById(id);

        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post singlePost : postIterable){
            postList.add(singlePost);
        }
        modelMap.addAttribute("posts", postList);

        return "posts";
    }

    @PostMapping("/post/addComment")
    public String addComment(@RequestParam String commentBody, @RequestParam long postId){
        PostComment postComment = new PostComment();
        postComment.setComment(commentBody);

        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post -> {
            post.addComment(postComment);
            postRepository.save(post);
        });

        return "";
    }
}
