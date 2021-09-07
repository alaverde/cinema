package com.politecnico.servicemovies;

import com.politecnico.servicemovies.entities.Movie;
import com.politecnico.servicemovies.repositories.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findByAll_return_ListMovies(){
        Movie movie = Movie.builder()
                .title("shrek")
                .director("Andrew Adamson")
                .rating(3)
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findAll();
        Assertions.assertThat(movies.size()).isEqualTo(1);
    }
}
