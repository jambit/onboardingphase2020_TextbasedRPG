package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.games.TicTacToe;

public class TicTacToeRoom extends AbstractRoom {

    @Override
    public void printWelcomeMessage() {
        System.out.println("Willkommen im TicTacToe Room");
    }

    @Override
    public void enter() {
        TicTacToe game = new TicTacToe();
        game.play();
        return;
    }
}
