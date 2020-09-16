package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.games.quizGame.QuizMaster;

public class QuizRoom extends AbstractRoom{
    @Override
    public void printWelcomeMessage() {
        System.out.println("Du betrittst den Raum." +
                "\n Eine merkwürdige Gestalt erwartet dich." +
                "\n Sie spricht dich an:");
    }

    @Override
    public void enter(Player player) {
        QuizMaster quizMaster = new QuizMaster();
        quizMaster.play();
        System.out.println("Die Gestalt fässt sich ans Herz." +
                "\n>>Argh! Du hast mich... besiegt!<<" +
                "\nDer QuizMaster sinkt zu Boden. Dein Weg ist frei!");
        return;

    }

}
