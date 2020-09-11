package com.jambit.onboarding2020.tbrpg.domain.Item;

public class Item {

   //Attribute
    private int sellValue;
    private String name;
    private String lore;

    //Konstruktor
    public Item() {}

    public Item(int sellValue, String name, String lore) {
        this.sellValue = sellValue;
        this.name = name;
        this.lore = lore;
    }

    //Methoden

    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

}
