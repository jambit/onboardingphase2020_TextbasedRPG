package com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz_02 implements Quizzzable {

    private int wrongAnswer1 = 15;
    private int wrongAnswer2 = 10;
    private int correctAnswer = 5;
    private String question = " Eine Flasche ̶K̶i̶n̶d̶e̶r̶b̶l̶u̶t̶... Eine Flasche Wein kostet mit Korken 110 Gold. " +
            "\nDie Flasche allein kostet schon 100 Gold mehr als der Korken. " +
            "\nWie viel kostet der Korken?";


    @Override
    public List<Integer> getAnswers() {

        List<Integer> answerList = new ArrayList<>();
        answerList.add(wrongAnswer1);
        answerList.add(wrongAnswer2);
        answerList.add(correctAnswer);

        Collections.shuffle(answerList);

        return answerList;

    }

    @Override
    public String getQuizQuestion() {
        return question;
    }

    @Override
    public boolean checkAnswer(int answer) {
        if (answer == correctAnswer)
            return true;
        else
            return false;
    }

    public boolean checkWrongs(int answer) {
        if (answer == wrongAnswer1 || answer == wrongAnswer2)
            return true;
        else
            return false;
    }
}

