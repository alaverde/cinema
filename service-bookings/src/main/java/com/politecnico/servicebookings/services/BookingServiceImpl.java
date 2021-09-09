package com.politecnico.servicebookings.services;


import com.politecnico.servicebookings.client.MovieClient;
import com.politecnico.servicebookings.client.ShowtimeClient;
import com.politecnico.servicebookings.client.UserClient;
import com.politecnico.servicebookings.entities.Booking;
import com.politecnico.servicebookings.entities.BookingItemMovie;
import com.politecnico.servicebookings.models.Movies;
import com.politecnico.servicebookings.models.Showtimes;
import com.politecnico.servicebookings.models.Users;
import com.politecnico.servicebookings.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements  BookingService{

    private final BookingRepository bookingRepository;
    private final MovieClient movieClient;
    private final ShowtimeClient showtimeClient;
    private final UserClient userClient;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findByUserId(Long id) {
        return bookingRepository.findBookingByUserId(id);
    }

    @Override
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();

        Users user = modelMapper.map(userClient.findById(booking.getUserId()).getData(),Users.class);
        booking.setUser(user);

        Showtimes showtime= modelMapper.map(showtimeClient.findById(booking.getShowTimeId()).getData(),Showtimes.class);
        booking.setShowtime(showtime);

        List<BookingItemMovie> itemMovies = booking.getItems().stream().map(
                bookingItemMovie -> {
                    Movies movie = modelMapper.map(movieClient.findById(bookingItemMovie.getMovieId()).getData(),Movies.class);
                    bookingItemMovie.setMovie(movie);
                    return bookingItemMovie;
                }).collect(Collectors.toList());
        return bookingRepository.findById(id).orElse(null);
    }
}
