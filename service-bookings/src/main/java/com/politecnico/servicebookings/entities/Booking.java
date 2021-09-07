package com.politecnico.servicebookings.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO: pendiente buscar como poner el primary
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @NotEmpty(message = "El id del usuario no puede ser nulo")
    @Column(name = "user_id")
    private Long userId;
    @NotEmpty(message = "El id del showtime no puede ser nulo")
    @Column(name = "showtime_id")
    private Long showTimeId;
    //private List<Object> movies;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
