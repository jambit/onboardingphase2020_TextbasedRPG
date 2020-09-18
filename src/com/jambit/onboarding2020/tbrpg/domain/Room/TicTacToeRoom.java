package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.core.RoomGamesResult;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.TicTacToe;

public class TicTacToeRoom extends AbstractRoom {

    @Override
    public void printWelcomeMessage() {
        System.out.println("Willkommen im TicTacToe Room" + "" +
                "\n  _________  ___  ________ _________  ________  ________ _________  ________  _______      \n" +
                "|\\___   ___\\\\  \\|\\   ____\\\\___   ___\\\\   __  \\|\\   ____\\\\___   ___\\\\   __  \\|\\  ___ \\     \n" +
                "\\|___ \\  \\_\\ \\  \\ \\  \\___\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___\\|___ \\  \\_\\ \\  \\|\\  \\ \\   __/|    \n" +
                "     \\ \\  \\ \\ \\  \\ \\  \\       \\ \\  \\ \\ \\   __  \\ \\  \\       \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\_|/__  \n" +
                "      \\ \\  \\ \\ \\  \\ \\  \\____   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\____   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\_|\\ \\ \n" +
                "       \\ \\__\\ \\ \\__\\ \\_______\\  \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\  \\ \\__\\ \\ \\_______\\ \\_______\\\n" +
                "        \\|__|  \\|__|\\|_______|   \\|__|  \\|__|\\|__|\\|_______|   \\|__|  \\|_______|\\|_______|\n" +
                "                                                                                          " +
                "\n ________  ________  ________  _____ ______      \n" +
                "|\\   __  \\|\\   __  \\|\\   __  \\|\\   _ \\  _   \\    \n" +
                "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\   \n" +
                " \\ \\   _  _\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\  \n" +
                "  \\ \\  \\\\  \\\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \n" +
                "   \\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\\n" +
                "    \\|__|\\|__|\\|_______|\\|_______|\\|__|     \\|__|");
    }

    @Override
    public void enter() throws PlayerDeadException {
        ItemGenerator itemGenerator = new ItemGenerator();
        Player player = Player.getPlayerInstance();

        TicTacToe game = new TicTacToe();
//
        game.play();

        System.out.println("Du hast " + player.getHealthState() + " Leben.");

        if (game.getGameresult() == RoomGamesResult.WON_EASY) {
            player.increaseHealthState(5);
            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich um 5 Lebenspunkte." +
                    "\nDu hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.WON_MIDDLE) {
            player.increaseHealthState(10);
            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich um 10 Lebenspunkte." +
                    "\nDu hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.WON_DIFFICULT) {
            player.increaseHealthState(15);
            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich um 15 Lebenspunkte." +
                    "\nDu hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.LOST) {
            player.decreaseHealthState(10);
            System.out.println("Vor Frustration hast du 10 Lebenspunkte verloren." +
                    "\nDu hast noch " + player.getHealthState() + " Lebenspunkte.");
        }


        return;


    }
}
