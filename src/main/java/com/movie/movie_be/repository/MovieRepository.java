package com.movie.movie_be.repository;


import com.movie.movie_be.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    MovieEntity findMovieEntityById(long id);

    MovieEntity findMovieEntityByNameContaining(String keyword);

    @Query("SELECT mv FROM MovieEntity mv WHERE mv.name LIKE %?1%")
    List<MovieEntity> findByNameContaining(String string);
}
