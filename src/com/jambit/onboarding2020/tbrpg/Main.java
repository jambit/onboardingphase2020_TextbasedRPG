package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.core.RoomGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our game :)");

        RoomGenerator roomGenerator = new RoomGenerator();
        ArrayList<AbstractRoom> rooms = roomGenerator.generateRooms();

        Player player = new Player();

        GameEngine gameEngine = new GameEngine(rooms, player);
        gameEngine.run();
    }
}

