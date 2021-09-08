package com.politecnico.serviceshowtimes.entities;

import com.politecnico.serviceshowtimes.models.Movies;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "showtimeitems")
public class ShowTimeItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="movie_id")
    private Long movieId;

    @Transient
    private Movies movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTimeItems that = (ShowTimeItems) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
