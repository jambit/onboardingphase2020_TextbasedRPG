package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.HealthPotion;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ItemGenerator {



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
        int nameindex = random.nextInt(weaponNames.size());
        int atkDamage = currentAtk - 5 + random.nextInt(20);
        return new Weapon(atkDamage, weaponNames.get(nameindex), weaponLore.get(nameindex), atkDamage);
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
    public Item generateRandomItem() {

        ArrayList<Item> roomLoot = new ArrayList<>();
            roomLoot.add(newJunk());
            roomLoot.add(newConsumable("health"));
            roomLoot.add(newConsumable("escape"));
            roomLoot.add(newWeapon(Player.getPlayerInstance().getAttackDamage()));

        return roomLoot.get(random.nextInt(roomLoot.size()));
    }
    public void dropLoot(){

//todo: ausprinten + später erst ins inventar

//todo:if player wants to take item

        Player.getPlayerInstance().putInInventory(generateRandomItem());


    }



}
