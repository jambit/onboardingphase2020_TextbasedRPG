package com.jambit.onboarding2020.tbrpg.domain.Player;

public abstract class Person {

    protected int healthState = 100;
    protected int attackDamage;

    public void attack (Person damagedPerson) {
        damagedPerson.healthState -= this.attackDamage;
        if (damagedPerson.healthState < 0) {
            damagedPerson.healthState = 0;
        }
    }

    public int getHealthState() {
        return healthState;
    }

    public void increaseHealthState(int additionalHP) {
        this.healthState += additionalHP;
    }

    public void decreaseHealthState(int lostHP) {
        this.healthState -= lostHP;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

}
