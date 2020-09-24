package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.core.RoomGamesResult;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.TicTacToe;
import com.jambit.onboarding2020.tbrpg.utils.Output;

public class TicTacToeRoom extends AbstractRoom {

    @Override
    public void printRoomMessage() {
        System.out.println("Hinter der nächsten Tür erspähst du etwas, das dich an TicTacToe denken lässt... aber...?");
    }
    public void printWelcomeMessage() {
        System.out.println("Du betrittst den Raum. Vor dir steht ein großes Alien vor einem Whiteboard.");
        Output.slow(">>Willst du das neueste Spiel ausprobieren?" +
                "\nDie Technik ist komplett neu. Die Grafik ist unglaublich." +
                "\nDas kannst du nicht verpassen!!<<");
        System.out.println(">>Willkommen im TicTacToe Room!<<" + "" +
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
    public void enter() throws PlayerDeadException, InterruptedException {
        ItemGenerator itemGenerator = new ItemGenerator();
        Player player = Player.getPlayerInstance();

        TicTacToe game = new TicTacToe();

        game.play();

        if (game.getGameresult() == RoomGamesResult.WON_EASY) {

            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich ein wenig.");
            player.increaseHealthState(5);
            System.out.println("Du hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            System.out.println();
            printGameIsWon();

            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.WON_MIDDLE) {

            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich ein wenig.");
            player.increaseHealthState(10);
            System.out.println("Du hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            System.out.println();
            printGameIsWon();

            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.WON_DIFFICULT) {

            System.out.println("Die Euphorie um das gewonnene Spiel heilt dich ein wenig.");
            player.increaseHealthState(15);
            System.out.println("Du hast jetzt " + player.getHealthState() + " Lebenspunkte.");
            System.out.println();
            printGameIsWon();

            itemGenerator.interactWithRoomLoot();
        } else if (game.getGameresult() == RoomGamesResult.LOST) {
            System.out.println("Vor Frustration hast du Lebenspunkte verloren.");
            player.decreaseHealthState(10);
            System.out.println("Du hast noch " + player.getHealthState() + " Lebenspunkte.");
            System.out.println();
            System.out.println("Das große Alien starrt auf dich herab.");
            Output.slow(">>War das nicht das beste Spiel, das du je gespielt hast?<<");
            System.out.println("Du lächelst gequält und drängst dich an ihm vorbei aus dem Raum.");

        }


        return;

    }

    private void printGameIsWon() {
        Output.slow("Endlich geschafft.");
        System.out.println("Das große Alien starrt auf dich herab.");
        Output.slow(">>War das nicht das beste Spiel, das du je gespielt hast?<<");
        System.out.println("Du nickst, lächelst und drängst dich an ihm vorbei aus dem Raum.");
    }

}
