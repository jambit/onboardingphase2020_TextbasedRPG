package com.jambit.onboarding2020.tbrpg.games.quizGame;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.games.Playable;
import com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes.*;

import java.util.*;

public class QuizMaster implements Playable {

    Random random = new Random();

    @Override
    public void play(Player player) {

        System.out.println(">>Willkommen bei diesem...<<" +
                "\n" +
                "\n" +
                "  █████   █    ██  ██▓▒███████▒ ▐██▌ \n" +
                "▒██▓  ██▒ ██  ▓██▒▓██▒▒ ▒ ▒ ▄▀░ ▐██▌ \n" +
                "▒██▒  ██░▓██  ▒██░▒██▒░ ▒ ▄▀▒░  ▐██▌ \n" +
                "░██  █▀ ░▓▓█  ░██░░██░  ▄▀▒   ░ ▓██▒ \n" +
                "░▒███▒█▄ ▒▒█████▓ ░██░▒███████▒ ▒▄▄  \n" +
                "░░ ▒▒░ ▒ ░▒▓▒ ▒ ▒ ░▓  ░▒▒ ▓░▒░▒ ░▀▀▒ \n" +
                " ░ ▒░  ░ ░░▒░ ░ ░  ▒ ░░░▒ ▒ ░ ▒ ░  ░ \n" +
                "   ░   ░  ░░░ ░ ░  ▒ ░░ ░ ░ ░ ░    ░ \n" +
                "    ░       ░      ░    ░ ░     ░    ");
        System.out.println(">>Du wirst drei Fragen beantworten müssen... nur so kannst du diesen Raum verlassen!<<");
        System.out.println(">>Die erste Frage lautet...<<");

        ArrayList<Quizzzable> possibleQuizzes = new ArrayList<>();
        possibleQuizzes.add(new Quiz_01());
        possibleQuizzes.add(new Quiz_02());
        possibleQuizzes.add(new Quiz_03());
        possibleQuizzes.add(new Quiz_04());
        int startSizeofPossibleList = possibleQuizzes.size();
        //todo: Make more quizzes and add them here (actual questions --lore?)

        ArrayList<Quizzzable> quizList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(possibleQuizzes.size());
            quizList.add(possibleQuizzes.get(randomIndex));
            possibleQuizzes.remove(randomIndex);

        }
        int rightAnswerCount = 0;
        for (Quizzzable quiz : quizList) {
            System.out.println("**************************************************************");
            System.out.println("| "+quiz.getQuizQuestion());
            List<Integer> answers = quiz.getAnswers();
            System.out.println("|  Ist die Antwort [" + answers.get(0) + "]?");
            System.out.println("|  Oder vielleicht [" + answers.get(1) + "]?");
            System.out.println("|  Oder doch [" + answers.get(2) + "]?");
            System.out.println("**************************************************************");


            //while loop and check with user input
            int nextIntegerInput = getNextIntegerInput();
            while (quiz.checkAnswer(nextIntegerInput) == false) {

                if (quiz.checkWrongs(nextIntegerInput) == true) {
                    System.out.println(">>Nicht... richtig!<<");
                    System.out.println("Der Quizmaster tritt dich.");
                    System.out.println("<hier wird dem Spieler Leben abgezogen>");
                    nextIntegerInput = getNextIntegerInput();




                } else {
                    System.out.println(">>Wähle eine der drei Möglichkeiten.<<");
                    System.out.println("Der Quizmaster sieht ungeduldig aus.");
                    nextIntegerInput = getNextIntegerInput();
                }


            }

            if (quiz.checkAnswer(nextIntegerInput) == true) {
                System.out.println(">>Richtig!<<");

                rightAnswerCount++;

                if (rightAnswerCount == 3) {

                    return;

                } else {
                    System.out.println(">>Hier kommt die nächste Frage...<<");
                }
            }


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



