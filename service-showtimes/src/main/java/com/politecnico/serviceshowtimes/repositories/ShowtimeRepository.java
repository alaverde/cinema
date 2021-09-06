package com.politecnico.serviceshowtimes.repositories;

import com.politecnico.serviceshowtimes.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

    List<Showtime> findAll();
    Showtime findShowtimeById(Long id);

}
