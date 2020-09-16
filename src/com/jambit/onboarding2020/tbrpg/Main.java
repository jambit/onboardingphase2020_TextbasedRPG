package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.games.QuizMaster;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {




    }
   /*public static void main(String[] args) {

      QuizMaster quizMaster = new QuizMaster("Wie viele Newbies hat Jambit dieses Jahr?", "Sechs");
      System.out.println("Frage: " + quizMaster.getQuizQuestion());
      System.out.println("[1] Fünf" +
          "\n[2] Sieben" +
          "\n[3] Sechs");

      int nextIntegerInput = getNextIntegerInput();
      while (nextIntegerInput != 3) {

         if (nextIntegerInput == 1 || nextIntegerInput == 2) {
            System.out.println("Nicht richtig.");
            nextIntegerInput = getNextIntegerInput();
         } else if (nextIntegerInput != 1 || nextIntegerInput != 2 || nextIntegerInput != 3) {
            System.out.println("Wähle [1], [2], oder [3].");
            nextIntegerInput = getNextIntegerInput();
         }
      }

      if (nextIntegerInput == 3) {
         System.out.println("Richtig!");
      }
   }

   private static Integer getNextIntegerInput() {
      Scanner scanner = new Scanner(System.in);
      Integer playerInput = null;
      while (playerInput == null) {
         try {
            playerInput = scanner.nextInt();

         } catch (InputMismatchException exception) {
            System.err.println("Fehleingabe. Nochmal!");
            scanner.nextLine();
         }
      }
      return playerInput;
   }*/
  /*  public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our game :)");

        RoomGenerator roomGenerator = new RoomGenerator();
        ArrayList<AbstractRoom> rooms = roomGenerator.generateRooms();

        GameEngine gameEngine = new GameEngine(rooms);
        gameEngine.run();
    }*/
}


