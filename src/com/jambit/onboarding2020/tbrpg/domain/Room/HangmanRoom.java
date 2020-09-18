package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.hangman.Hangman;
import com.jambit.onboarding2020.tbrpg.games.hangman.HangmanLoseException;
import java.io.InputStreamReader;

public class HangmanRoom extends AbstractRoom{
    @Override
    public void enter() throws PlayerDeadException {

        GameInput in = new GameInput(new InputStreamReader(System.in));
        String line = "";

        Hangman hangman = new Hangman();
        hangman.drawPitch();
        hangman.drawLetterInput();

        while (in.gameState()) {
            String input = "";

            try {
                input = in.inputHangmanString();
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                if (input.length() > 1) {
                    evaluateWord(in, hangman, input);
                } else {
                    evaluateLetter(in, hangman, input);
                }
            } catch (HangmanLoseException e) {
                System.out.println(e.getMessage());
                Player.getPlayerInstance().decreaseHealthState(20);
                in.exitGame();
            }

            hangman.drawPitch();
            hangman.drawLetterInput();
        }
    }

    private void evaluateWord(GameInput in, Hangman hangman, String input) throws HangmanLoseException {
        if (hangman.guessWord(input.toCharArray())) {
            in.winGame();
            System.out.println("Spiel gewonnen");
        } else {
            System.out.println("Buchstabe falsch geraten!");
            hangman.increaseStage();
        }
    }

    private void evaluateLetter(GameInput in, Hangman hangman, String input) throws HangmanLoseException {
        char inputChar = input.charAt(0);

        if (hangman.guessLetter(inputChar)) {
            System.out.println("Buchstabe richtig geraten!");
            if (hangman.guessWord(hangman.getKnownWord())) {
                // Spiel hier auch gewonnen
                in.winGame();
                System.out.println("Spiel gewonnen");
            }
        } else {
            System.out.println("Buchstabe falsch geraten!");
            hangman.increaseStage();
        }
    }
}
