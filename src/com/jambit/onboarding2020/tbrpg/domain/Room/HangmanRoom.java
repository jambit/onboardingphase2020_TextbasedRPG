package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.hangman.Hangman;
import com.jambit.onboarding2020.tbrpg.games.hangman.HangmanLoseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanRoom extends AbstractRoom {

    private final String wordlist = System.getProperty("user.dir") + "/resources/nouns_10-20.txt";

    @Override
    public void printWelcomeMessage() {
        System.out.println("Willkommen zu " +
                "\n _" +
                "\n| |" +
                "\n| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  " +
                "\n| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ " +
                "\n| | | | (_| | | | | (_| | | | | | | (_| | | | |" +
                "\n|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|" +
                "\n                    __/ |" +
                "\n                   |___/" +
                "\n"
        );
    }

    @Override
    public void enter() throws PlayerDeadException, FileNotFoundException {

        GameInput gameInput = new GameInput(new InputStreamReader(System.in));
        String randomWord = "";
        randomWord = this.getRandomWord();

        Hangman hangman = new Hangman(randomWord);
        hangman.drawPitch();
        hangman.drawLetterInput();

        while (gameInput.isGameRunning()) {
            String input = "";

            try {
                input = gameInput.inputStringToUppercase();
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                if (input.length() > 1) {
                    evaluateWord(gameInput, hangman, input);
                } else {
                    evaluateLetter(gameInput, hangman, input);
                }
            } catch (HangmanLoseException e) {
                System.out.println(e.getMessage());
                System.out.println("\nDas richtige Wort wäre " + String.valueOf(hangman.getSearchedWord()) + " gewesen..");
                Player.getPlayerInstance().decreaseHealthState(20);
                System.out.println("Du hast 20 Lebenspunkte verloren. \nDu hast noch " + Player.getPlayerInstance().getHealthState() + " Lebenspunkte");
                gameInput.endGame();
            }

            hangman.drawPitch();
            hangman.drawLetterInput();
        }
    }

    private void evaluateWord(GameInput in, Hangman hangman, String input) throws HangmanLoseException {
        if (hangman.guessWord(input)) {
            in.endGame();
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
                in.endGame();
                System.out.println("Spiel gewonnen");
            }
        } else {
            System.out.println("Buchstabe falsch geraten!");
            hangman.increaseStage();
        }
    }

    public String getRandomWord() throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(new File(this.wordlist)); sc.hasNext(); ) {
            ++n;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0)
                result = line.toUpperCase();
        }

        return result;
    }
}
