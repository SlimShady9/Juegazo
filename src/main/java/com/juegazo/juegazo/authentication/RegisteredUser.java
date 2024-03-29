package com.juegazo.juegazo.authentication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "RegisteredUser")
public class RegisteredUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegisteredUser")
    private Long idRegisteredUser;

    @Column(name = "nameUser")
    private String name;
}
