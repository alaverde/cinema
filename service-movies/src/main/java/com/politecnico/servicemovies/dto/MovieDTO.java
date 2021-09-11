package com.politecnico.servicemovies.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO implements Serializable {

    private long id;
    private String title;
    private String director;
    private int rating;

}
