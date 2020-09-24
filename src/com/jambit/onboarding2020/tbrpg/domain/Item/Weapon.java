package com.jambit.onboarding2020.tbrpg.domain.Item;

public class Weapon extends Item {

    //Attributes
    private int atkDamage;
    private double critChance;
    private double hitChance;

    public void setAtkDamage(int atkDamage) {
        this.atkDamage = atkDamage;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public double getHitChance() {
        return hitChance;
    }

    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }


    //Constructor


    public Weapon(int sellValue, String name, String lore, int atkDamage, double critChance, double hitChance) {
        super(sellValue, name, lore);
        this.atkDamage = atkDamage;
        this.critChance = critChance;
        this.hitChance = hitChance;
    }

    //Methods
    public int getAtkDamage() {
        return atkDamage;
    }

    /*public void setAtkDamage(int atkDamage) {
        this.atkDamage = atkDamage;
    }*/

    @Override
    public String toString() {
        return this.getName() + ", \t"+
                "Verkaufspreis = " + this.getSellValue() + ", \t" +
                "Angriffsschaden = " + this.getAtkDamage();
    }

}
