package com.jambit.onboarding2020.tbrpg.domain.Player;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.utils.GameConstants;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;


public class Player extends Person {

    private static Player playerInstance;
    private int balance = 100;
    private final ArrayList<Item> inventory;
    private Weapon equippedWeapon;

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

    public void equipWeapon(Weapon weapon) {
        if (equippedWeapon == null) {
            this.attackDamage = this.attackDamage + weapon.getAtkDamage();
            this.equippedWeapon = weapon;
        } else {
            System.out.println("Du hast bereits" + equippedWeapon + " ausgerüstet.");
            System.out.println("Du musst die Waffe erst ablegen.");
        }
    }

    public void unequipWeapon() {
        if (equippedWeapon == null) {
            System.out.println("Du hast aktuell keine Waffe ausgerüstet.");
        } else {
            System.out.println("Du hast " + equippedWeapon + " abgelegt.");
        }
    }

}











