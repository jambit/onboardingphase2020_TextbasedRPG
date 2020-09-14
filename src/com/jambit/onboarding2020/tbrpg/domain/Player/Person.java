package com.jambit.onboarding2020.tbrpg.domain.Player;

public abstract class Person {

    protected int healthState = 100;
    protected String name;
    protected int attackDamage;

    public void attack (Person damagedPerson) {
        damagedPerson.healthState -= this.attackDamage;
    }

    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
