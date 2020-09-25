package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.quizGame.QuizMaster;

public class QuizRoom extends AbstractRoom {

    @Override
    public void printRoomMessage() {
        System.out.println("Der nächste Raum wird von Flutlichtern beleuchtet. Es erinnert dich an Gameshows oder Quizspiele.");
    }
    public void printWelcomeMessage() {
        System.out.println("Du betrittst den Raum." +
                "\nVor dir siehst du eine große Halle, die hell erleuchtet und mit Kameras ausgestattet ist." +
                "\nEine merkwürdige Gestalt erwartet dich, verborgen hinter einem Vorhang nur wenige Meter vor dir." +
                "\nSie scheint in einen langen Umhang gehüllt zu sein." +
                "\nPlötzlich springt die Gestalt auf und enthüllt einen pinken Anzug und eine glitzernde Krawatte." +
                "\n>>Du bist in meine Falle getappt, du Narr! Ich bin der QUIZMASTER!<<" +
                "\nDer QuizMaster macht eine Verbeugung, wobei sein zu kurzer Anzug so etwas wie " +
                "\neinen Echsenschwanz nicht verbergen kann.");
        GameInput.waitTillEnter();
    }

    @Override
    public void enter() throws PlayerDeadException, InterruptedException {

        QuizMaster quizMaster = new QuizMaster();
        quizMaster.play();
        System.out.println("Der QuizMaster fässt sich ans Herz." +
                "\nSeine schlitzartigen Pupillen weiten sich." +
                "\n>>Argh! Du hast mich... besiegt!<<" +
                "\nDer QuizMaster sinkt zu Boden. Dein Weg ist frei!");
        GameInput.waitTillEnter();



        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.interactWithRoomLoot();

    }


}




