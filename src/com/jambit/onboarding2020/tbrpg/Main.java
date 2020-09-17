package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.DungeonGenerator;
import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.QuizRoom;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


        QuizRoom quizRoom = new QuizRoom();
        quizRoom.printWelcomeMessage();
        quizRoom.enter(Player.getPlayerInstance());


        /*System.out.println("Welcome to our game :)");

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        ArrayList<AbstractRoom> rooms = dungeonGenerator.generateRooms();

        Player player = new Player();

        GameEngine gameEngine = new GameEngine(rooms, player);
        gameEngine.run();*/
    }
}

