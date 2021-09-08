package com.politecnico.serviceshowtimes.services;

import com.politecnico.serviceshowtimes.client.MovieClient;
import com.politecnico.serviceshowtimes.entities.ShowTimeItems;
import com.politecnico.serviceshowtimes.entities.Showtime;
import com.politecnico.serviceshowtimes.models.Movies;
import com.politecnico.serviceshowtimes.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public Showtime update(Long id, Showtime showtime){
        Showtime showtimeNew = showtimeRepository.findShowtimeById(id);
        showtimeNew.setDate(showtime.getDate());
        return showtimeRepository.save(showtimeNew);
    }

    @Override
    public Showtime findById(Long id) {
        Showtime showtime = showtimeRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        List<ShowTimeItems> movieList= showtime.getItems().stream()
                .map(showTimeItems -> {
                    Movies movies = modelMapper.map(movieClient.findById(showTimeItems.getId()), Movies.class);
                    showTimeItems.setMovies(movies);
                    return showTimeItems;
                        }).collect(Collectors.toList());
        return showtimeRepository.findById(id).orElse(null);
    }


}
