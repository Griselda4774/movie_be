package com.movie.movie_be.controller;

import com.movie.movie_be.dto.MovieDTO;
import com.movie.movie_be.entity.MovieEntity;
import com.movie.movie_be.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity GetMovies(){
        List<MovieEntity> movies = movieService.getMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/movie")
    public ResponseEntity createMovie(@RequestBody MovieEntity movieEntity) {
        MovieEntity movie = movieService.postMovie(movieEntity);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movie/{movieID}")
    public ResponseEntity getMovieDetail(@PathVariable long movieID) {
        MovieEntity movieEntity = movieService.getMovieDetail(movieID);
        return ResponseEntity.ok(movieEntity);
    }

    @GetMapping("/movie/{keyword}")
    public ResponseEntity getMoviesDetailByName(@PathVariable String keyword) {
        MovieEntity movie = movieService.getMoviesDetailByName(keyword);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movie/get-by-name/{keyword}")
    public ResponseEntity getMoviesDetailByNameContaining(@PathVariable String keyword) {
        List<MovieEntity> movies = movieService.getMoviesByNameContaining(keyword);
        return ResponseEntity.ok(movies);
    }
}
