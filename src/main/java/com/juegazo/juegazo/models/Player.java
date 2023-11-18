package com.juegazo.juegazo.models;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.enums.PlayerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlayer")
    private Long idPlayer;

    @Column(name = "playerType")
    @Enumerated(EnumType.STRING)
    private PlayerType type;

    @Column(name = "experience")
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registeredUser")
    private RegisteredUser user;
    
    

    public Integer calculateLevel() {
        return 1;
    }

    
}
