package com.politecnico.serviceshowtimes.repositories;

import com.politecnico.serviceshowtimes.entities.ShowTimeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeItemRepository extends JpaRepository<ShowTimeItems,Long>{

}
