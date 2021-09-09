package com.politecnico.servicebookings.client;

import com.politecnico.servicebookings.models.Movies;
import com.politecnico.servicebookings.models.Showtimes;
import com.politecnico.servicebookings.utils.Response;
import com.politecnico.servicebookings.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowtimeClientFallBackHystrix implements ShowtimeClient{

    private final ResponseBuilder builder;
    private final List<Object> list;

    @Override
    public Response findById(Long id) {
        Showtimes showimes = new Showtimes();
                showimes.setId(1L);
                showimes.setDate(null);
                showimes.setItems(list);
        return  builder.success(showimes);
    }

}