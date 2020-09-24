package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.DungeonGenerator;
import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to our game :)");

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        ArrayList<AbstractRoom> rooms = dungeonGenerator.generateRooms();

        GameEngine gameEngine = new GameEngine(rooms);
        gameEngine.run();
    }
}