package com.politecnico.serviceuser.entities;


import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   //TODO: pendiente buscar como poner el primary
    @Column(name = "number_id", unique = true, nullable = false)
    private Long id;
    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "El apellido no puede ser vacio")
    @Column(name = "last_name")
    private String lastName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
