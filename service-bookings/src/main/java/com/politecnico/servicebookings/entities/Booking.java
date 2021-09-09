package com.politecnico.servicebookings.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.politecnico.servicebookings.models.Showtimes;
import com.politecnico.servicebookings.models.Users;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
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
    //TODO: pendiente buscar como poner el primary y el not null de entero
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "showtime_id")
    private Long showTimeId;

    @Transient
    private Users user;

    @Transient
    private Showtimes showtime;

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<BookingItemMovie> items;


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
