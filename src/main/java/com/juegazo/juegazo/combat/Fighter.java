package com.juegazo.juegazo.combat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Fighter {
    
    private Integer turn;
    private Integer maxHealth;
    private Integer health;
}
