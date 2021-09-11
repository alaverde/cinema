package com.politecnico.servicemovies.controller;

import com.politecnico.servicemovies.client.BookingClient;
import com.politecnico.servicemovies.dto.MovieDTO;
import com.politecnico.servicemovies.entities.Movie;
import com.politecnico.servicemovies.services.MovieService;
import com.politecnico.servicemovies.utils.Format;
import com.politecnico.servicemovies.utils.Response;
import com.politecnico.servicemovies.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder;
    private final BookingClient bookingClient;

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(Format.formatMessage((result)));
        }

        movieService.save(movie);

        MovieDTO movieDTO = MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .rating(movie.getRating())
                .build();
        return builder.success(movieDTO);

    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Movie movie = movieService.findById(id);
        Response response = null;
        try{
            response = bookingClient.findAllByIdMovie(id);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        MovieDTO movieDTO = MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .rating(movie.getRating())
                .build();
        if(response != null){
            return builder.failed(movieDTO);
        }else{
            if (movie == null) {
                return builder.failed(null);
            }
            movieService.delete(movie);

            movieDTO = MovieDTO.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .director(movie.getDirector())
                    .rating(movie.getRating())
                    .build();

            return builder.success(movieDTO);
        }
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll() {
        List<Movie> movies = movieService.findAll();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<MovieDTO> listMovieDTO = new ArrayList<MovieDTO>();

        for (Movie movie : movies) {
            listMovieDTO.add(MovieDTO.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .director(movie.getDirector())
                    .rating(movie.getRating())
                    .build());
        }
        return ResponseEntity.ok(listMovieDTO);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return builder.success(null);
        }

        MovieDTO movieDTO = MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .rating(movie.getRating())
                .build();

        return builder.success(movieDTO);
    }


}
