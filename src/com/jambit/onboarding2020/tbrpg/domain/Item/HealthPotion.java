package com.jambit.onboarding2020.tbrpg.domain.Item;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class HealthPotion extends Item implements Consumable {

    Player player = Player.getPlayerInstance();

    public HealthPotion() {
        this.setName("Heiltrank");
        this.setLore("Damit du nicht gleich abkrazt...");
        this.setSellValue(5);
    }

    @Override
    public void consume() {
        player.increaseHealthState(20);
        System.out.println("Der Spieler wurde um 20 Punkte geheilt.\nAktuelle HP: " + player.getHealthState());
        player.takeItemFromInventory("Heiltrank");
    }
}
