package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.MerchantRoom;

public class Test_Room {
    // TODO: 16.09.2020 Delete this class if not further needed
    public static void main(String[] args) {

        Player player = Player.getPlayerInstance();

        System.out.print("Spielerinventar:");
        player.printInventory();
        System.out.println();
        System.out.println(player.getBalance());
        MerchantRoom merchantRoom = new MerchantRoom();
        merchantRoom.printWelcomeMessage();
        merchantRoom.enter();


    }
}