package com.jambit.onboarding2020.tbrpg.games.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private final String wordlist = System.getProperty("user.dir") + "/resources/nouns_10-20.txt";
    private final char[] searchedWord;
    private char[] knownWord;
    private int stage;

    public ArrayList<String> words = new ArrayList<String>();

    public Hangman() throws FileNotFoundException {
        this.searchedWord = getRandomWord();
        initialisizeKnownWord();
    }

    private void initialisizeKnownWord() {
        this.knownWord = new char[searchedWord.length];
        for (int i = 0, wordLength = this.searchedWord.length; i < wordLength; i++) {
            this.knownWord[i] = '_';
        }
        this.knownWord[0] = searchedWord[0];
    }

    public char[] getRandomWord() throws FileNotFoundException {
        char[] result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(new File(this.wordlist)); sc.hasNext(); ) {
            ++n;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0)
                result = line.toUpperCase().toCharArray();
        }

        return result;
    }

    public char[] getSearchedWord() {
        return searchedWord;
    }

    public void drawPitch() {
        String content = switch (this.stage) {
            case 0 -> "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n";
            case 1 -> "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    " /                         \n";
            case 2 -> "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    "                           \n" +
                    " / \\                      \n";
            case 3 -> "  *                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 4 -> "  *-----------             \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 5 -> "  *-----------             \n" +
                    "  | /                      \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 6 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 7 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 8 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |          |             \n" +
                    "  |          |             \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 9 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |          |/            \n" +
                    "  |          |             \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 10 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |         \\|/           \n" +
                    "  |          |             \n" +
                    "  |                        \n" +
                    " / \\                      \n";
            case 11 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |         \\|/           \n" +
                    "  |          |             \n" +
                    "  |           \\           \n" +
                    " / \\                      \n";
            case 12 -> "  *-----------             \n" +
                    "  | /        |             \n" +
                    "  |          0             \n" +
                    "  |         \\|/           \n" +
                    "  |          |             \n" +
                    "  |         / \\           \n" +
                    " / \\                      \n";
            default -> "";
        };
        System.out.println(content);
    }

    public void drawLetterInput() {
        for (char letter : this.knownWord) {
            System.out.print(letter + " ");
        }
        System.out.print("\n");
    }

    public boolean guessLetter(char letter) {
        boolean status = false;

        for (int i = 0; i < this.searchedWord.length; i++) {
            if (this.searchedWord[i] == letter && this.knownWord[i] != letter) {
                this.knownWord[i] = letter;
                status = true;
            }
        }

        return status;
    }

    public char[] getKnownWord() {
        return knownWord;
    }

    public void increaseStage() throws HangmanLoseException {
        this.stage += 1;

        if (this.stage == 12) {
            throw new HangmanLoseException("Du hast Hangman verloren!");
        }
    }

    public boolean guessWord(char[] guessedWord) {
        return Arrays.equals(guessedWord, this.searchedWord);
    }
}
