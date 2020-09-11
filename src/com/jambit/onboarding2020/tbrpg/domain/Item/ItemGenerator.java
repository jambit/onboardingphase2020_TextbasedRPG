package com.jambit.onboarding2020.tbrpg.domain.Item;

import java.util.ArrayList;
import java.util.Random;

import static com.jambit.onboarding2020.tbrpg.domain.Item.Consumable.ESCAPE;
import static com.jambit.onboarding2020.tbrpg.domain.Item.Consumable.HEALTH;

public class ItemGenerator {

    Random random = new Random();
    ArrayList<String> junkNames = new ArrayList<>();
    ArrayList<String> junkLore = new ArrayList<>();
    ArrayList<String> weaponNames = new ArrayList<>();
    ArrayList<String> weaponLore = new ArrayList<>();

    public ItemGenerator(){
        this.initializeJunkNames();
        this.initializeJunkLore();
        this.initializeWeaponNames();
        this.initializeWeaponLore();
    }

    public Item newJunk(){
        return new Item(20,
                junkNames.get(random.nextInt(junkNames.size())),
                junkLore.get(random.nextInt(junkLore.size())));
    }

    public Weapon newWeapon(int currentAtk){
        int nameindex = random.nextInt(weaponNames.size());
        int atkDamage = currentAtk-5+ random.nextInt(20);
        return new Weapon(atkDamage, weaponNames.get(nameindex), weaponLore.get(nameindex),atkDamage);
    }

    public Item newConsumable(Consumable consumable){
        if(consumable.equals(HEALTH)){
            return newHealthPotion();
        }
        else if( consumable.equals(ESCAPE)) {
            return newEscapeRope();
        }
        return null;
    }

    private Item newHealthPotion(){
        return new Item(5, "Heiltrank", "Heilt dich ein bisschen :)");
    }

    private Item newEscapeRope(){
        return new Item(10, "Fluchttrick", "Bruder muss los!");
    }

    private void initializeJunkNames(){
        junkNames.add("Rubin");
        junkNames.add("Smaragd");
        junkNames.add("Diamant");
        junkNames.add("Eisen");
        junkNames.add("Goldring");
        junkNames.add("Medallion");
    }

    private void initializeJunkLore(){
        this.junkLore.add("Wie das glitzert...");
        this.junkLore.add("Das sieht wertvoll aus.");
        this.junkLore.add("Ich hoffe das ist wertvoller als es aussieht.");
        this.junkLore.add("Das kann ich verkaufen.");
        this.junkLore.add("Juhu");
        this.junkLore.add("#Insert junk-lore here");
    }

    private void initializeWeaponNames(){
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

}
