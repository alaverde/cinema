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
    private String name;
    private String lastName;
}
