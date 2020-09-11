package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.*;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.Tradeable;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.Merchant;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test_Room {

    public static void main(String[] args) {

        ItemGenerator itemGenerator = new ItemGenerator();
        Player player = new Player();
        Merchant merchant = new Merchant(itemGenerator, player);

        player.putInInventory(itemGenerator.newJunk());
        System.out.print("Spielerinventar:");
        player.printInventory();
        System.out.println("");
        System.out.println(player.getBalance());

        System.out.print("Händlerinventar: ");
        merchant.printInventory();

    }
}