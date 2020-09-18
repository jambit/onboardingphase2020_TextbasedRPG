package com.jambit.onboarding2020.tbrpg.core;

public class GameState {

    private static final GameState gameStateInstance = new GameState();
    public boolean escapeRopeActive = false;

    public static GameState getGameStateInstance() {
        return gameStateInstance;
    }

}
