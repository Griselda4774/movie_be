package com.movie.movie_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String avatarURL;

    @OneToMany(mappedBy = "director")
    @JsonIgnore
    List<MovieEntity> movies;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    List<MovieEntity> moviesActors;
}
