package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Room.Merchant;

import javax.naming.InsufficientResourcesException;

public class Player implements Tradeable {

    private int balance;
    private int atkDamage;
    private Inventory inventory;

    public Player() {
        this.balance = 100;
        this.atkDamage = 10;
        this.inventory = new Inventory();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAtkDamage() {
        return atkDamage;
    }

    public void setAtkDamage(int atkDamage) {
        this.atkDamage = atkDamage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void sell(Item item) {
        this.inventory.pullFromInventory(item);
        this.setBalance(this.getBalance() + item.getSellValue());
    }

    public void buy(Item item, Merchant merchant) {
        try {
            merchant.sell(item, this);
        } catch (InsufficientResourcesException e) {
            System.out.println("Du hast nicht genug Geld, um dir das zu leisten");
        }
    }

    @Override
    public void putInInventory(Item item) {
        inventory.putInInventory(item);
    }

    public void printInventory() {
        this.inventory.printInventory();
    }

}
