package com.juegazo.juegazo.authentication;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    
    private Long idUser;
    private String name;
}
