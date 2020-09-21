package com.jambit.onboarding2020.tbrpg.domain.Players;

import com.jambit.onboarding2020.tbrpg.domain.Items.*;
import com.jambit.onboarding2020.tbrpg.domain.Items.Item;
import com.jambit.onboarding2020.tbrpg.domain.Items.Weapon;
import com.jambit.onboarding2020.tbrpg.utils.*;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;


public class Player extends Person {

    private static final Player playerInstance = new Player();
    private int balance = 100;
    private final ArrayList<Item> inventory;
    private Weapon equippedWeapon;

    public Player() {
        inventory = new ArrayList<>();
        attackDamage = GameConstants.PLAYER_ATTACK_DAMAGE;
    }

    public static Player getPlayerInstance() {
        return playerInstance;
    }
    public int getBalance() {
        return balance;
    }

    public int increaseBalance(int addedMoney){
        this.balance = balance + addedMoney;
        return balance;
    }

    public void sell(Item item) {
        this.inventory.remove(item);
        this.balance += item.getSellValue();
    }

    public void attack (Enemy damagedPerson) throws EnemyDeadException {
        damagedPerson.decreaseHealthState(this.attackDamage);
    }

    @Override
    public void decreaseHealthState(int lostHP) throws PlayerDeadException {
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
            throw new PlayerDeadException("Spieler ist tot");
        }
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

    public Weapon getEquippedWeapon(){
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        if (equippedWeapon == null) {
            this.attackDamage = this.attackDamage + weapon.getAtkDamage();
            System.out.println("Dein Angriffsschaden liegt nun bei " + this.attackDamage);
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
            this.attackDamage = this.attackDamage - equippedWeapon.getAtkDamage();
            equippedWeapon = null;
        }
    }

    public Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Consumable getConsumableFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                try {
                    return (Consumable) item;
                } catch (Exception e) {
                    break;
                }
            }
        }
        return null;
    }

    public void putInInventory(Item item) {
        this.inventory.add(item);
    }

    public ArrayList<Weapon> getWeaponsFromInventory() {
        ArrayList<Weapon> weaponList = new ArrayList<>();
        for (Item item : this.inventory) {
            try {
                weaponList.add((Weapon) item);
            } catch (Exception e) {
                System.out.print("");
            }
        }
        return weaponList;
    }

    public void printWeaponsFromInventory() {
        ArrayList<Weapon> weaponsFromInventory = this.getWeaponsFromInventory();
        int counter = 1;
        for (Weapon weapon : weaponsFromInventory) {
            System.out.println(counter + ": " + weapon);
            counter++;
        }
    }

    public Item takeItemFromInventory(String itemName) {
        Item item = this.getItemFromInventory(itemName);
        this.inventory.remove(item);
        return item;
    }

}
