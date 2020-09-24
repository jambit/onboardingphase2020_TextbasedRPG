package com.jambit.onboarding2020.tbrpg.domain.Player;

public abstract class Person {

    protected int healthState = 100;
    protected int attackDamage;


    public int getHealthState() {
        return healthState;
    }

    public void increaseHealthState(int additionalHP) {

        if (this.healthState >= 100) {
            this.healthState = 100;
            System.out.println("Du hast bereits maximale Lebenspunkte!");
        }
        else{
            this.healthState += additionalHP;
            System.out.println("Du wurdest um " + additionalHP + " Lebenspunkte geheilt.");
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
