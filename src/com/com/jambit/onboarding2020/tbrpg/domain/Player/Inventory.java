package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import java.util.ArrayList;

public class Inventory {

    private int maxSlotCount;
    private ArrayList<Item> inventory = new ArrayList<>();

    //Methods

    public int getMaxSlotCount() {
        return maxSlotCount;
    }

    public void setMaxSlotCount(int maxSlotCount) {
        this.maxSlotCount = maxSlotCount;
    }

    public boolean getInventoryFull() {
        return inventory.size() == maxSlotCount;
    }

    public ArrayList<Item> getContent() {
        return this.inventory;
    }

    public void putInInventory(Item item) {
        this.inventory.add(item);
    }

    public void pullFromInventory(Item item) {
        this.inventory.remove(item);
    }

    public void printInventory() {
        for (Item item : inventory) {
            System.out.print(item.getName() + " : ");
        }
    }

}
