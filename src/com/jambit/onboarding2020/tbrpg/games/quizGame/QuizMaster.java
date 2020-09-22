package com.jambit.onboarding2020.tbrpg.games.quizGame;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.games.Playable;
import com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes.*;

import java.util.*;

public class QuizMaster implements Playable {

    Random random = new Random();

    @Override
    public void play() throws PlayerDeadException, InterruptedException {


        System.out.println(">>Willkommen bei meinem...<<" +
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
        Thread.sleep(2000);
        System.out.println(">>Du wirst drei Fragen beantworten müssen... nur so kannst du diesen Raum verlassen!<<");
        System.out.println(">>Die erste Frage lautet...<<");

        ArrayList<Quiz> possibleQuizzes = new ArrayList<>();
        possibleQuizzes.add(new Quiz_01());
        possibleQuizzes.add(new Quiz_02());
        possibleQuizzes.add(new Quiz_03());
        possibleQuizzes.add(new Quiz_04());
        possibleQuizzes.add(new Quiz_05());
        possibleQuizzes.add(new Quiz_06());
        possibleQuizzes.add(new Quiz_07());
        possibleQuizzes.add(new Quiz_08());
        possibleQuizzes.add(new Quiz_09());


        //todo: no repitition

        ArrayList<Quizzzable> quizList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(possibleQuizzes.size());
            quizList.add(possibleQuizzes.get(randomIndex));
            possibleQuizzes.remove(randomIndex);

        }
        int rightAnswerCount = 0;
        for (Quizzzable quiz : quizList) {
            System.out.println("**************************************************************");
            System.out.println(quiz.getQuizQuestion());
            List<Integer> answers = quiz.getAnswers();
            System.out.println("|  Ist die Antwort [" + answers.get(0) + "]?");
            System.out.println("|  Oder vielleicht [" + answers.get(1) + "]?");
            System.out.println("|  Oder etwa doch  [" + answers.get(2) + "]?");
            System.out.println("**************************************************************");


            //while loop and check with user input
            int nextIntegerInput = getNextIntegerInput();
            while (quiz.checkAnswer(nextIntegerInput) == false) {

                if (quiz.checkWrongs(nextIntegerInput) == true) {
                    System.out.println(">>Nicht... richtig!<<");
                    System.out.println("Der QuizMaster tritt dich.");

                    player.decreaseHealthState(10);
                    System.out.println("Du hast 10 Lebenspunkte verloren." +
                            "\nDu hast noch " + Player.getPlayerInstance().getHealthState() + " Lebenspunkte.");

                    System.out.println(">>Versuch es nochmal!<<");
                    nextIntegerInput = getNextIntegerInput();

                } else {
                    System.out.println("Wähle eine der drei Möglichkeiten.");
                    System.out.println("Der Quizmaster sieht ungeduldig aus.");
                    nextIntegerInput = getNextIntegerInput();
                }


            }

            if (quiz.checkAnswer(nextIntegerInput) == true) {
                System.out.println(">>Richtig!<<");
                rightAnswerCount++;

                if (rightAnswerCount == 3) {

                    player.increaseHealthState(5);
                    System.out.println("Die Euphorie über die richtige Antwort heilt dich um 5 Lebenspunkte." +
                            "\nDu hast jetzt " + player.getHealthState() + " Lebenspunkte.");


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



