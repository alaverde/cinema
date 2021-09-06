package com.politecnico.serviceshowtimes.controller;

import com.politecnico.serviceshowtimes.dto.ShowtimeDTO;
import com.politecnico.serviceshowtimes.entities.Showtime;
import com.politecnico.serviceshowtimes.services.ShowtimeService;
import com.politecnico.serviceshowtimes.utils.Response;
import com.politecnico.serviceshowtimes.utils.ResponseBuilder;
import com.politecnico.serviceshowtimes.utils.Format;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuilder builder;

    @GetMapping
    public ResponseEntity<List<ShowtimeDTO>> findAll() {
        List<Showtime> showtimes = showtimeService.findAll();
        if (showtimes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ShowtimeDTO> listShowtimeDTO = new ArrayList<ShowtimeDTO>();

        for (Showtime showtime : showtimes) {
            listShowtimeDTO.add(ShowtimeDTO.builder()
                    .id(showtime.getId())
                    .fecha(showtime.getDate())
                    .build());
        }
        return ResponseEntity.ok(listShowtimeDTO);
    }


    @PostMapping
    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(Format.formatMessage((result)));
        }

        showtimeService.save(showtime);

        ShowtimeDTO showtimeDTO = ShowtimeDTO.builder()
                .id(showtime.getId())
                .fecha(showtime.getDate())
                .build();

        return builder.success(showtimeDTO);
    }


    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if (showtime == null){
            return builder.success(null);
        }
        ShowtimeDTO showtimeDTO = ShowtimeDTO.builder()
                .id(showtime.getId())
                .fecha(showtime.getDate())
                .build();

        return builder.success(showtimeDTO);
    }

    @PutMapping
    public Response update(BindingResult result,@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if(result.hasErrors()){
            return builder.failed(Format.formatMessage((result)));
        }

        showtimeService.save(showtime);
        ShowtimeDTO showtimeDTO = ShowtimeDTO.builder()
                .id(showtime.getId())
                .fecha(showtime.getDate())
                .build();

        return builder.success(showtimeDTO);
    }

}
