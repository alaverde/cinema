package com.politecnico.servicemovies.services;

import com.politecnico.servicemovies.entities.Movie;

import java.util.List;


public interface MovieService {

    void save(Movie movie);
    void delete(Movie movie);
    List<Movie> findAll();
    Movie findById(Long id);
}
