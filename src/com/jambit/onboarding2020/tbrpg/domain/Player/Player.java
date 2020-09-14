package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
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

    public void buy(ArrayList merchantInventory, Item item) {
        // if balance nicht ausreichend oder inventory voll, dann exception werfen
        this.inventory.add(item);
        merchantInventory.remove(item);
        this.balance -= item.getSellValue();
    }

    public void printInventory() {
        System.out.println("Your Inventory is");
        for (Item i : inventory) {
            System.out.println(i);
        }
    }
}
