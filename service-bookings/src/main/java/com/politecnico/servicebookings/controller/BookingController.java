package com.politecnico.servicebookings.controller;


import com.politecnico.servicebookings.dto.BookingDTO;
import com.politecnico.servicebookings.entities.Booking;
import com.politecnico.servicebookings.services.BookingService;
import com.politecnico.servicebookings.utils.Format;
import com.politecnico.servicebookings.utils.Response;
import com.politecnico.servicebookings.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuilder builder;


    @PostMapping
    public Response save(@Valid @RequestBody Booking booking, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(Format.formatMessage((result)));
        }

        bookingService.save(booking);

       /* BookingDTO userDTO = BookingDTO.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .showTimeId(booking.getShowTimeId())
                .build();

        */

        return builder.success(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        bookingService.delete(booking);

        BookingDTO bookingDTO = BookingDTO.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .showTimeId(booking.getShowTimeId())
                .build();

        return ResponseEntity.ok(bookingDTO);
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll() {
        List<Booking> bookings = bookingService.findAll();
        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<BookingDTO> listBookingDTO = new ArrayList<BookingDTO>();

        for (Booking booking : bookings) {
            listBookingDTO.add(BookingDTO.builder()
                    .id(booking.getId())
                    .userId(booking.getUserId())
                    .showTimeId(booking.getShowTimeId())
                    .build());
        }

        return ResponseEntity.ok(listBookingDTO);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            return builder.success(null);
        }

      /*  BookingDTO bookingDTO = BookingDTO.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .showTimeId(booking.getShowTimeId())
                .build();
                
       */

        return builder.success(booking);
    }


    @GetMapping("/users/{userid}")
    public Response findByUserId(@PathVariable("userid") Long id) {
        List<Booking> bookings = bookingService.findByUserId(id);
        if (bookings == null) {
            return builder.success(null);
        }

        List<BookingDTO> listBookingDTO = new ArrayList<BookingDTO>();

        for (Booking booking : bookings) {
            listBookingDTO.add(BookingDTO.builder()
                    .id(booking.getId())
                    .userId(booking.getUserId())
                    .showTimeId(booking.getShowTimeId())
                    .build());
        }

        return builder.success(listBookingDTO);
    }

}
