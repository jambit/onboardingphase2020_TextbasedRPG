package com.jambit.onboarding2020.tbrpg.core;

import java.io.*;

public class GameInput extends BufferedReader {
    private boolean gameState = true;

    public GameInput(Reader in) {
        super(in);
    }

    public boolean gameState() {
        return gameState;
    }

    public void exitGame() {
        System.out.println("Du hast das Spiel beendet!");
        this.gameState = false;
    }

    public void looseGame() {
        System.out.println("Du hast das Spiel leider verloren! Versuche es nochmal?");
        this.gameState = false;
    }

    public void winGame() {
        System.out.println("Du hast gewonnen!");
        this.gameState = false;
    }

    public int inputInteger() throws Exception {
        int intInput;

        try {
            String input = this.readLine();
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("Der Input ist leider nicht valide, gib eine Zahl ein!");
        }

        return intInput;
    }

    public boolean inputRoomdecision() throws Exception {
        String input = "";

        try {
            input = this.readLine();
        } catch (Exception e) {
            throw new Exception("Eingabe ungültig");
        }

        if (input.equalsIgnoreCase("enter")) {
            return true;
        } else if (input.equalsIgnoreCase("quit")) {
            this.exitGame();
            return false;
        }

        throw new Exception("Eingabe ungültig, bitte gib enter oder exit ein");
    }

    public static void clearScreen() {
        for (int i = 0; i < 80 * 300; i++)
            System.out.print("\n");
    }
}
