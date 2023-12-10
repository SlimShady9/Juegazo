package com.juegazo.juegazo.combat;

import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.EnemyType;
import com.juegazo.juegazo.models.Enemy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Defender extends Fighter{

    private EnemyType enemyType;

    public static Defender makeFromEnemy(Enemy enemy) {
        Integer level = enemy.getLevel();
        Integer maxHealth = Defender.calculateHealthFor(enemy.getEnemyType(), level);
        //Integer 
        Defender def = Defender.builder()
            .enemyType(enemy.getEnemyType())
            .build();
        def.setMaxHealth(maxHealth);
        def.setHealth(maxHealth);
        def.setBaseDamage(calculateBaseDamage(enemy.getEnemyType(), level));
        def.setPhisicalArmor(calculatePhicicalArmor(enemy.getEnemyType(), level));
        def.setMagicalArmor(calculateMagicalArmor(enemy.getEnemyType(), level));
        return def;
    }

    @Override
    public Integer calculateDamage(AttackType attackType) {
        Integer baseDmg = this.getBaseDamage();
        switch (attackType) {
            case MAGICAL:
                baseDmg = baseDmg * this.getMagicalArmor();
                break;
            case PHISICAL:
                baseDmg = baseDmg * this.getPhisicalArmor();
                break;
            case SPECIAL:
                baseDmg = baseDmg * (this.getMagicalArmor() + this.getPhisicalArmor());
                break;
            default:
                break;
        }
        return baseDmg;

        
    }

    public static Integer calculateHealthFor(EnemyType enemyType, Integer level) {
        Integer health = 0;
        if (EnemyType.BOSS.equals(enemyType)) {
            health = (400 * level) - 2000;
        }
        if (EnemyType.GOBLIN.equals(enemyType)) {
            health = (150* level)- 1000;
        }
        return health;

    }

    public static Integer calculateBaseDamage(EnemyType enemyType, Integer level) {
        Integer baseDmg = 0;
        if (EnemyType.BOSS.equals(enemyType)) {
            baseDmg = (2 * level) - 10;
        }
        if (EnemyType.GOBLIN.equals(enemyType)) {
            baseDmg = level - 6;
        }
        return baseDmg;
    }

    public static Integer calculatePhicicalArmor(EnemyType enemyType, Integer level) {
        Integer phicicalArmor = 0;
        if (EnemyType.BOSS.equals(enemyType)) {
            phicicalArmor = level - 5;
        }
        if (EnemyType.GOBLIN.equals(enemyType)) {
            phicicalArmor = level - 9;
        }
        return phicicalArmor;
    }

    public static Integer calculateMagicalArmor(EnemyType enemyType, Integer level) {
        Integer magicalArmor = 0;
        if (EnemyType.BOSS.equals(enemyType)) {
            magicalArmor = level - 5;
        }
        if (EnemyType.GOBLIN.equals(enemyType)) {
            magicalArmor = level - 9;
        }
        return magicalArmor;
    }
    
}
