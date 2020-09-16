package com.jambit.onboarding2020.tbrpg.games.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz_02 implements Quizzzable {

    private int wrongAnswer1 = 1;
    private int wrongAnswer2 = 2;
    private int correctAnswer = 3;
    private String question = "Quiz02: Sag 3";


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

