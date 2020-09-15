package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.core.RoomGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.games.TicTacToe;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("Welcome to our game :)");

//        RoomGenerator roomGenerator = new RoomGenerator();
//        ArrayList<AbstractRoom> rooms = roomGenerator.generateRooms();
//
//        GameEngine gameEngine = new GameEngine(rooms);
//        gameEngine.run();

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play();



    }
}

