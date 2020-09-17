package com.jambit.onboarding2020.tbrpg.games.quizGame.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz_03 implements Quizzzable {


    private int wrongAnswer1 = 3;
    private int wrongAnswer2 = 5;
    private int correctAnswer = 6;
    private String question = "Der kleine Hans leiht sich von ̶m̶i̶r̶ seinem lieben Freund 150 Gold und verspricht,\n" +
            "jeden Tag doppelt so viel wie am letzten zu zahlen... Am ersten Tag 5 Gold, am zweiten 10 und so weiter.\n" +
            "̶s̶o̶n̶s̶t̶ ̶g̶e̶h̶ö̶r̶t̶ ̶e̶r̶ ̶m̶i̶r̶\n" +
            "In wievielen Tagen schuldet er  ̶m̶i̶r̶ nichts mehr?";


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



