package com.movie.movie_be.service;

import com.movie.movie_be.dto.MovieDTO;
import com.movie.movie_be.entity.MovieEntity;
import com.movie.movie_be.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    public MovieEntity postMovie(MovieEntity movieEntity)
    {
        movieRepository.save(movieEntity);
        return null;
    }

    public MovieEntity getMovieDetail(long movieID){
        return movieRepository.findMovieEntityById(movieID);
    }

    public MovieEntity getMoviesDetailByName(String keyword) {
        return movieRepository.findMovieEntityByNameContaining(keyword);
    }

    public List<MovieEntity> getMoviesByNameContaining(String keyword) {
        return movieRepository.findByNameContaining(keyword);
    }
}
