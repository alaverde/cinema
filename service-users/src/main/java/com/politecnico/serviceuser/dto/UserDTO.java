package com.politecnico.serviceuser.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private long id;
    private String nombre;
    private String apellido;
}
