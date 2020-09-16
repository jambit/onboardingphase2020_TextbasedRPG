package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.games.quizzes.*;

import java.util.*;

public class QuizMaster implements Playable {

    Random random = new Random();

    @Override
    public void play() {

        System.out.println("Mein Name ist Günther Jauch...");

        ArrayList<Quizzzable> possibleQuizzes = new ArrayList<>();
        possibleQuizzes.add(new Quiz_01());
        possibleQuizzes.add(new Quiz_02());
        possibleQuizzes.add(new Quiz_03());
        possibleQuizzes.add(new Quiz_04());
        //todo: Make more quizzes and add them here (actual questions --lore?)

        ArrayList<Quizzzable> quizList = new ArrayList<>();
        int randomIndex = random.nextInt(possibleQuizzes.size());
        for (int i = 0; i < 3; i++) {
            quizList.add(possibleQuizzes.get(randomIndex));
            possibleQuizzes.remove(randomIndex);

        }

        for (Quizzzable quiz : quizList) {
            System.out.println("Frage: " + quiz.getQuizQuestion());
            List<Integer> answers = quiz.getAnswers();
            System.out.println("Ist die Antwort [" + answers.get(0) + "]?");
            System.out.println("Oder vielleicht [" + answers.get(1) + "]?");
            System.out.println("Oder doch [" + answers.get(2) + "]?");


            //while loop and check with user input
            int nextIntegerInput = getNextIntegerInput();
            while (quiz.checkAnswer(nextIntegerInput) == false) {

                if (quiz.checkWrongs(nextIntegerInput) == true) {
                    System.out.println("Nicht richtig.");
                    nextIntegerInput = getNextIntegerInput();
                    System.out.println("<hier wird dem Spieler Leben abgezogen>");
                    // -HP
                } else {
                    System.out.println("Wähle eine der drei Möglichkeiten.");
                    nextIntegerInput = getNextIntegerInput();
                }
            }

            if (quiz.checkAnswer(nextIntegerInput) == true) {
                System.out.println("Richtig!");


            }
            // todo: if 3 correct then leave

        }


    }

    private static Integer getNextIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        Integer playerInput = null;
        while (playerInput == null) {
            try {
                playerInput = scanner.nextInt();

            } catch (InputMismatchException exception) {
                System.out.println("Wähle eine der drei Möglichkeiten.");
                scanner.nextLine();
            }
        }
        return playerInput;
    }


}



