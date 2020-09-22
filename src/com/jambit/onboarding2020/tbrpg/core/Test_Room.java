package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Items.HealthPotion;
import com.jambit.onboarding2020.tbrpg.domain.Items.Item;
import com.jambit.onboarding2020.tbrpg.domain.Players.Player;
import com.jambit.onboarding2020.tbrpg.domain.Players.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Room.MobRoom;

import java.util.ArrayList;

public class Test_Room {

    // TODO: 16.09.2020 Delete this class if not further needed
    public static void main(String[] args) throws PlayerDeadException {

        Player player = Player.getPlayerInstance();
        HealthPotion hp = new HealthPotion();

        System.out.print("Spielerinventar:");
        player.putInInventory(hp);
        player.printInventory();
        System.out.println();
        System.out.println(player.getBalance());

        System.out.print("Händlerinventar: ");
        MobRoom mb = new MobRoom();
        mb.enter();

    }
}