package com.jambit.onboarding2020.tbrpg.domain.Player;
import com.jambit.onboarding2020.tbrpg.utils.GameConstants;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import java.util.ArrayList;


public class Player extends Person {

    private static Player playerInstance;
    private int balance = 100;
    private final ArrayList<Item> inventory;

    private Player() {
        inventory = new ArrayList<>();
        attackDamage = GameConstants.PLAYER_ATTACK_DAMAGE;
    }

    public static Player getPlayerInstance() {
        if (Player.playerInstance == null) {
            Player.playerInstance = new Player();
        }
        return Player.playerInstance;
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
        for (int j = 0; j < inventory.size(); j++) {
            System.out.println(j + ") " + inventory.get(j).getName());
        }
    }
}











