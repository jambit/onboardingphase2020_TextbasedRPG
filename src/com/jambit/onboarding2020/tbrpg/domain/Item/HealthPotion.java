package com.jambit.onboarding2020.tbrpg.domain.Item;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class HealthPotion extends Item implements Consumable {

    public HealthPotion() {
        this.setName("Heiltrank");
        this.setLore("Damit du nicht gleich abkrazt...");
        this.setSellValue(5);
    }

    @Override
    public void consume(Player player) {
        player.setHealthState(player.getHealthState() + 20);
        System.out.println("Der Spieler wurde um 20 Punkte geheilt.\nAktuelle HP: " + player.getHealthState());
    }
}
