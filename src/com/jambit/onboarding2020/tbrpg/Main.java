package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.core.RoomGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.TicTacToeRoom;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        TicTacToeRoom ticTacToeRoom = new TicTacToeRoom();
        ticTacToeRoom.printWelcomeMessage();

        ticTacToeRoom.enter();

//        System.out.println("Welcome to our game :)");
//
//        RoomGenerator roomGenerator = new RoomGenerator();
//        ArrayList<AbstractRoom> rooms = roomGenerator.generateRooms();
//
//        GameEngine gameEngine = new GameEngine(rooms);
//        gameEngine.run();

    }
}

