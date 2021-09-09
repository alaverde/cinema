package com.politecnico.serviceshowtimes.client;

import com.politecnico.serviceshowtimes.models.Movies;
import com.politecnico.serviceshowtimes.utils.Response;
import com.politecnico.serviceshowtimes.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBackHystrix implements MovieClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Movies movie = new Movies();
                movie.setId(1L);
                movie.setTitle("");
                movie.setDirector("");
                movie.setRating(0);
        return  builder.success(movie);
    }

}