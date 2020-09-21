package com.jambit.onboarding2020.tbrpg.domain.Item;

public class Weapon extends Item {

    //Attributes
    private int atkDamage;

    //Constructor
    public Weapon() {

    }

    public Weapon(int atkDamage) {
        this.atkDamage = atkDamage;
    }

    public Weapon(int sellValue, String name, String lore, int atkDamage) {
        super(sellValue, name, lore);
        this.atkDamage = atkDamage;
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
                "Preis = " + this.getSellValue() + ", \t" +
                "Atk = " + this.getAtkDamage();
    }

}
