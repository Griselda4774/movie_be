package com.movie.movie_be.service;

import com.movie.movie_be.entity.PostEntity;
import com.movie.movie_be.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public List<PostEntity> getPosts() {
        return postRepository.findAll();
    }
}
