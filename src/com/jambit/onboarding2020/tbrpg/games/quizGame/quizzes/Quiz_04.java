package com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz_04 implements Quizzzable {

    private int wrongAnswer1 = 30;
    private int wrongAnswer2 = 45;
    private int correctAnswer = 35;
    private String question = "Theo ist  ̶l̶e̶c̶k̶e̶r̶e̶ 13 Jahre alt. \n" +
            "In drei Jahren ist sein Großvater doppelt so alt wie Theos Vater \n" +
            "und in sieben Jahren ist der Großvater viermal so alt wie Theo. Wie alt ist der Vater von Theo?";


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
