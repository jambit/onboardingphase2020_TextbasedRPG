package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.games.quizGame.Quiz;

import java.util.ArrayList;

public class GameState {

    private static final GameState gameStateInstance = new GameState();
    public boolean escapeRopeActive = false;
    public static final ArrayList<Quiz> QuizMasterQuizzes = new ArrayList<>();

    private GameState() {
    }

    public static GameState getGameStateInstance() {
        return gameStateInstance;
    }

}
