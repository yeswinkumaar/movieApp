package com.moviebookingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.models.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {

    List<Movie> findByMovieNameStartingWith(String movieName);

    Movie findByMovieNameAndTheatreName(String moviename,String theatreName);

    void deleteByMovieName(String movieName);
}

