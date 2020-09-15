package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.games.Quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Quiz quiz = new Quiz("Wie viele Newbies hat Jambit dieses Jahr?", "Sechs");
        System.out.println("Frage: " + quiz.getQuizQuestion());
        System.out.println("[1] Fünf" +
                "\n[2] Sieben" +
                "\n[3] Sechs");

        Scanner scanner = new Scanner(System.in);
        int playerInput = -1;

        while (playerInput == -1) {

            try {
                String next = scanner.next();

            } catch (InputMismatchException exception) {
                System.err.println("Fehleingabe. Nochmal!");

            }
        }

            while (playerInput != 3) {

                if (playerInput == 1 || playerInput == 2) {

                    System.out.println("Nicht richtig.");
                    playerInput = scanner.nextInt();
                } else if (playerInput != 1 || playerInput != 2 || playerInput != 3) {
                    System.out.println("Wähle [1], [2], oder [3].");
                    playerInput = scanner.nextInt();

                }

            }

            if (playerInput == 3) {
                System.out.println("Richtig!");
            }
            scanner.close();




    }
  /*  public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our game :)");

        RoomGenerator roomGenerator = new RoomGenerator();
        ArrayList<AbstractRoom> rooms = roomGenerator.generateRooms();

        GameEngine gameEngine = new GameEngine(rooms);
        gameEngine.run();
    }*/
}


