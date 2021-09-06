package com.politecnico.serviceshowtimes.services;

import com.politecnico.serviceshowtimes.entities.Showtime;
import com.politecnico.serviceshowtimes.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Showtime update(Long id, Showtime showtime){
        Showtime showtimeNew = showtimeRepository.findShowtimeById(id);
        showtimeNew.setDate(showtime.getDate());
        return showtimeRepository.save(showtimeNew);
    }
}
