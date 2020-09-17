package com.jambit.onboarding2020.tbrpg.domain.Room;

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
    public void enter() {
        TicTacToe game = new TicTacToe();
//        while (game.getGameresult() == GameResult.TIE){
//            game.play();
//        }
        game.play();
        return;
        //TODO: If lost --> reduce life balance
        //TODO: If won --> party hard
    }
}
