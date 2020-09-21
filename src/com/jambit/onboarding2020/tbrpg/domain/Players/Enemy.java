package com.jambit.onboarding2020.tbrpg.domain.Players;

public class Enemy extends Person {

    public Enemy () {
        this.attackDamage = 5;
        this.healthState = 50;
    }

    public void attack (Player damagedPerson) throws PlayerDeadException{
        damagedPerson.decreaseHealthState(this.attackDamage);
    }

    public void decreaseHealthState(int lostHP) throws EnemyDeadException{
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
            throw new EnemyDeadException("Du hast den Gegener besiegt");
        }
    }
}
