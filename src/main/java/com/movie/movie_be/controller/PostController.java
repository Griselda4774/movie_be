package com.movie.movie_be.controller;

import com.movie.movie_be.entity.PostEntity;
import com.movie.movie_be.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post")
    public ResponseEntity GetPosts(){
        List<PostEntity> posts = postService.getPosts();
        return ResponseEntity.ok(posts);
    }
}
