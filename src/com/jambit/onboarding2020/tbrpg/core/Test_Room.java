package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.EscapeRope;
import com.jambit.onboarding2020.tbrpg.domain.Item.HealthPotion;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Room.MobRoom;

public class Test_Room {

    // TODO: 16.09.2020 Delete this class if not further needed
    public static void main(String[] args) throws PlayerDeadException {

        Player player = Player.getPlayerInstance();
        HealthPotion hp = new HealthPotion();
        EscapeRope er = new EscapeRope();

        System.out.print("Spielerinventar:");
        player.putInInventory(hp);
        player.putInInventory(er);
        player.printInventory();
        System.out.println();
        System.out.println(player.getBalance());

        System.out.print("Händlerinventar: ");
        MobRoom mb = new MobRoom();
        mb.enter();

    }
}