package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class Test_Room {
    // TODO: 16.09.2020 Delete this class if not further needed
    public static void main(String[] args) {

        Player player = new Player();

        System.out.print("Spielerinventar:");
        player.printInventory();
        System.out.println();
        System.out.println(player.getBalance());

        System.out.print("Händlerinventar: ");

    }
}