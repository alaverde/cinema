package com.politecnico.servicemovies;

import com.politecnico.servicemovies.entities.Movie;
import com.politecnico.servicemovies.repositories.MovieRepository;
import com.politecnico.servicemovies.services.MovieService;
import com.politecnico.servicemovies.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);
        Movie movie = Movie.builder()
                .id(5L)
                .title("Harry Potter")
                .director("David Yates")
                .rating(5)
                .build();
        Mockito.when(movieRepository.findById(5L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movies() {
        Movie movie = movieService.findById(5L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Harry Potter");
    }

}
