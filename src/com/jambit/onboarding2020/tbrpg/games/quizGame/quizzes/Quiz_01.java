package com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz_01 implements Quizzzable {

    private int wrongAnswer1 = 5;
    private int wrongAnswer2 = 3;
    private int correctAnswer = 6;
    private String question = "Quiz01: Dies ist ein placeholder. Die Antwort ist 6.";

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
