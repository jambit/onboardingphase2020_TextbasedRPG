package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.MerchantRoom;

public class Test_Room {

    public static void main(String[] args) {

        Player player = new Player();

        System.out.print("Spielerinventar:");
        player.printInventory();
        System.out.println();
        System.out.println(player.getBalance());

        System.out.print("Händlerinventar: ");

    }
}