package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;

public class Player extends Person {

    private final ArrayList<Item> inventory;
    private int balance = 100;

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
        if (this.inventory.size() == 0) {
            System.out.println("--LEER--");
        } else {
            System.out.println("Dein Inventar:");
            int counter = 1;
            for (Item i : inventory) {
                System.out.println(counter + ": " + i);
                counter++;
            }
        }
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }
}
