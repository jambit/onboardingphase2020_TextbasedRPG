package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;

public class Player extends Person {

    private int balance = 100;
    private final ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void sell(Item item) {
        this.inventory.remove(item);
        this.balance += item.getSellValue();
    }

    public void buy(Item item) throws InsufficientResourcesException {
        // if balance nicht ausreichend oder inventory voll, dann exception werfen
        if (this.getBalance() > item.getSellValue()) {
            this.inventory.add(item);
            this.balance -= item.getSellValue();
        } else throw new InsufficientResourcesException();
    }

    public void printInventory() {
        int counter = 1;
        System.out.println("Your Inventory is");
        for (Item i : inventory) {
            System.out.println(counter + ": " + i);
            counter++;
        }
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }
}
