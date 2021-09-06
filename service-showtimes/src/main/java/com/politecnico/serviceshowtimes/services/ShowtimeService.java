package com.politecnico.serviceshowtimes.services;

import com.politecnico.serviceshowtimes.entities.Showtime;

import java.util.Date;
import java.util.List;

public interface ShowtimeService {

    List<Showtime> findAll();
    void save(Showtime showtime);
    Showtime findById(Long id);
    Showtime update(Long id, Showtime showtime);

}
