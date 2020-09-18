package com.jambit.onboarding2020.tbrpg.domain.Player;

public abstract class Person {

    protected int healthState = 100;
    protected int attackDamage;


    public int getHealthState() {
        return healthState;
    }

    public void increaseHealthState(int additionalHP) {
        this.healthState += additionalHP;

        if (this.healthState > 100) {
            this.healthState = 100;
        }
    }

    public void decreaseHealthState(int lostHP) throws EnemyDeadException {
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
