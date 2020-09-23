package com.jambit.onboarding2020.tbrpg.domain.Players;

public class Enemy extends Person {

    private int critChance ;
    private int hitChance;

    public Enemy () {
        this.attackDamage = (int)(Math.random()*20 + 10);
        this.healthState = (int)(Math.random()*100 + 50);

    }

    public void attack (Player damagedPerson) throws PlayerDeadException{
        this.critChance = (int)(Math.random() + 0.3);
        this.hitChance = (int)(Math.random() + 0.3);
        if (Math.random() <= hitChance){
            if (Math.random()<= critChance) {
                damagedPerson.decreaseHealthState((int) (this.attackDamage
                        + (this.attackDamage * critChance)));
                System.out.println("Aua was soll das! Der Gegner hat einen kritischen Treffer erzielt!");
            }
            else {
                damagedPerson.decreaseHealthState(this.attackDamage);
                System.out.println("Der Gegner hat dich getroffen... das war nicht sehr effektiv");
            }
        }
        else
            System.out.println("Du hast den Angriff abgewehrt!");
    }


    public void decreaseHealthState(int lostHP) throws EnemyDeadException{
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
            throw new EnemyDeadException("Du hast den Gegener besiegt");
        }
    }
}
