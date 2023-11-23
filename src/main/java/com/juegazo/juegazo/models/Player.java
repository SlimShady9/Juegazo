package com.juegazo.juegazo.models;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.enums.PlayerType;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString(exclude = {"room"})
@NoArgsConstructor @AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "registeredUser")
    private RegisteredUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    @Nonnull
    private Room room;
    
    

    public Integer calculateLevel() {
        return experience / 100;
    }

    
}
