package com.jambit.onboarding2020.tbrpg.domain.Items;

import com.jambit.onboarding2020.tbrpg.domain.Players.Player;

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
        System.out.println("Aktuelle HP: " + player.getHealthState());
        player.takeItemFromInventory("Heiltrank");
    }
}
