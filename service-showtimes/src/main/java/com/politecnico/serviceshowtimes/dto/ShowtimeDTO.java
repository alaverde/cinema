package com.politecnico.serviceshowtimes.dto;

import com.politecnico.serviceshowtimes.models.Movies;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowtimeDTO implements Serializable {
    private Long id;
    private Date fecha;
    private List<Movies> movie;
}