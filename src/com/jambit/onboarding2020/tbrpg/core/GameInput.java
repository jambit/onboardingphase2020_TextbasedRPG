package com.jambit.onboarding2020.tbrpg.core;

import java.io.*;
import java.util.Scanner;

public class GameInput extends BufferedReader {
    private boolean isGameRunning = true;

    public GameInput(Reader in) {
        super(in);
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void endGame() {
        this.isGameRunning = false;
    }

    public int inputInteger() throws InvalidInputException{
        int intInput;

        try {
            String input = this.readLine();
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new InvalidInputException("Der Input ist leider nicht valide, gib eine Zahl ein!");
        }

        return intInput;
    }

    public String inputStringToUppercase() throws InvalidInputException {
        String input;

        try {
            input = this.readLine();
        } catch (Exception e) {
            throw new InvalidInputException("Ungültige Eingabe. Versuche es nochmal!");
        }

        if (input.length() == 0) {
            throw new InvalidInputException("Gib einen Buchstabe oder das ganze Wort ein");
        }

        return input.toUpperCase();
    }
    public boolean inputRoomdecision() throws InvalidInputException{
        String input = "";

        try {
            input = this.readLine();
        } catch (Exception e) {
            throw new InvalidInputException("Eingabe ungültig");
        }

        if (input.equalsIgnoreCase("enter")) {
            return true;
        } else if (input.equalsIgnoreCase("quit")) {
            this.endGame();
            return false;
        }

        throw new InvalidInputException("Eingabe ungültig, bitte gib enter oder exit ein");
    }

    public static void clearScreen() {
        for (int i = 0; i < 80 * 300; i++)
            System.out.print("\n");
    }

    public static void waitTillEnter() {

        Scanner scanner = new Scanner(System.in);
        boolean abort = false;
        while (!abort) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("")) { //if enter-key is pressed
                System.out.println("Enter key pressed or empty input ");
                abort = true;
            }
        }
    }

}
