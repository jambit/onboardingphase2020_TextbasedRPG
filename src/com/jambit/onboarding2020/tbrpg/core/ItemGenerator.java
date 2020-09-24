package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.HealthPotion;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.InputStreamReader;

public class ItemGenerator {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Random random = new Random();
    ArrayList<String> junkNames = new ArrayList<>();
    ArrayList<String> junkLore = new ArrayList<>();
    ArrayList<String> weaponNames = new ArrayList<>();
    ArrayList<String> weaponLore = new ArrayList<>();

    public ItemGenerator() {
        this.initializeJunkNames();
        this.initializeJunkLore();
        this.initializeWeaponNames();
        this.initializeWeaponLore();
    }

    public Item newJunk() {
        return new Item(20,
                junkNames.get(random.nextInt(junkNames.size())),
                junkLore.get(random.nextInt(junkLore.size())));
    }

    public Weapon newWeapon(int currentAtk) {
        double critChance = Math.random();
        double hitChance = Math.random();
        int nameindex = random.nextInt(weaponNames.size());
        int atkDamage = currentAtk - 5 + random.nextInt(20);
        return new Weapon(atkDamage, weaponNames.get(nameindex), weaponLore.get(nameindex), atkDamage, critChance, hitChance);
    }

    public Item newConsumable(String consumable) {
        if (consumable.equals("health")) {
            return new HealthPotion();
        } else if (consumable.equals("escape")) {
            return newEscapeRope();
        }
        return null;
    }

    /*private Item newHealthPotion() {
        return new Item(5, "Heiltrank", "Heilt dich ein bisschen :)");
    }*/

    private Item newEscapeRope() {
        return new Item(10, "Fluchttrick", "Bruder muss los!");
    }

    private void initializeJunkNames() {
        junkNames.add("Rubin");
        junkNames.add("Smaragd");
        junkNames.add("Diamant");
        junkNames.add("Eisen");
        junkNames.add("Goldring");
        junkNames.add("Medallion");
    }

    private void initializeJunkLore() {
        this.junkLore.add("Wie das glitzert...");
        this.junkLore.add("Das sieht wertvoll aus.");
        this.junkLore.add("Ich hoffe das ist wertvoller als es aussieht.");
        this.junkLore.add("Das kann ich verkaufen.");
        this.junkLore.add("Juhu");
        this.junkLore.add("#Insert junk-lore here");
    }

    private void initializeWeaponNames() {
        this.weaponNames.add("Schwert");
        this.weaponNames.add("Dolch");
        this.weaponNames.add("Messer");
        this.weaponNames.add("Katana");
        this.weaponNames.add("Bastardschwert");
    }

    private void initializeWeaponLore() {
        this.weaponLore.add("Achtung Scharf!");
        this.weaponLore.add("Super zum Käseschneiden");
        this.weaponLore.add("Hat schonmal bessere Tage gesehen");
        this.weaponLore.add("KATANA!");
        this.weaponLore.add("Was ein Bastard...");
    }

    private Item getRoomLoot() {
        ArrayList<Item> lootList = new ArrayList<>();
        lootList.add(newWeapon(Player.getPlayerInstance().getAttackDamage()));
        lootList.add(newJunk());
        lootList.add(newConsumable("health"));
        lootList.add(newConsumable("escape"));

        return lootList.get(random.nextInt(lootList.size()));

    }

    public void interactWithRoomLoot() {

        Item lootItem = this.getRoomLoot();
        int lootMoney = (random.nextInt(10) + random.nextInt(10) + 3);

        Player.getPlayerInstance().increaseBalance(lootMoney);
        System.out.println("Beim Verlassen des Raumes findest du " + lootMoney + " Gold.");
        System.out.println("Jetzt hast du " + Player.getPlayerInstance().getBalance() + " Gold.");

        System.out.println("SPIELERINVENTAR:");
        //todo: print out nicely: inventory, balance, health, attack, equippedWeapon


        System.out.println("Außerdem findest folgendes Item: " + lootItem);
        System.out.println("Möchtest du es [einstecken] oder es liegen lassen und [weitergehen]?");


        String gameInput = "";
        try {
            gameInput = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gameInput.equalsIgnoreCase("einstecken")) {
            Player.getPlayerInstance().putInInventory(lootItem);
            System.out.println("Du steckst das Item ein und gehst weiter.");
        } else if (gameInput.equalsIgnoreCase("weitergehen")) ;
            System.out.println("Du lässt das Item liegen und gehst weiter.");
        {
            return;
        }
    }
}




