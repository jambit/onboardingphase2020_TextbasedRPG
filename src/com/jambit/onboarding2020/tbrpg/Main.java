package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.DungeonGenerator;
import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.TicTacToeRoom;

import com.jambit.onboarding2020.tbrpg.domain.Room.BossRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.QuizRoom;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BossRoom bossRoom = new BossRoom();
        bossRoom.enter();

/*
        System.out.println("Welcome to our game :)");

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        ArrayList<AbstractRoom> rooms = dungeonGenerator.generateRooms();

        Player player = Player.getPlayerInstance();

        GameEngine gameEngine = new GameEngine(rooms);
        gameEngine.run();*/
    }
}

