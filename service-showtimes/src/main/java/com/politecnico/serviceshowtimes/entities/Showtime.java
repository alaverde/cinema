package com.politecnico.serviceshowtimes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "showtime")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO: pendiente buscar como poner el primary

    @Column(name = "number_id", unique = true, nullable = false)
    private Long id;
    @Column(name = "date", nullable = false)
    private Date date;

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "showtime_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<ShowTimeItems> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return id.equals(showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
