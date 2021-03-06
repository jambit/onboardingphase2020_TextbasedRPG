package com.jambit.onboarding2020.tbrpg.games.quizGame;

import com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes.Quizzzable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz implements Quizzzable {

    protected int wrongAnswer1 = 0;
    protected int wrongAnswer2 = 0;
    protected int correctAnswer = 0;
    protected String question = "<NOT DEFINED>";

    public List<Integer> getAnswers() {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(wrongAnswer1);
        answerList.add(wrongAnswer2);
        answerList.add(correctAnswer);

        Collections.shuffle(answerList);

        return answerList;

    }

    public String getQuizQuestion() {
        return question;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }

    public boolean checkWrongs(int answer) {
        return answer == wrongAnswer1 || answer == wrongAnswer2;
    }

}
