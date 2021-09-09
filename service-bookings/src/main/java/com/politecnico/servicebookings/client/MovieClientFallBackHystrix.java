package com.politecnico.servicebookings.client;

import com.politecnico.servicebookings.models.Movies;
import com.politecnico.servicebookings.utils.Response;
import com.politecnico.servicebookings.utils.ResponseBuilder;
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
                movie.setTitle("Hp");
                movie.setDirector("David");
                movie.setRating(2);
        return  builder.success(movie);
    }

}