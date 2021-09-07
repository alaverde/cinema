package com.politecnico.servicebookings.services;

import com.politecnico.servicebookings.entities.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    List<Booking> findByUserId(Long userId);
    Booking findById(Long id);
}
