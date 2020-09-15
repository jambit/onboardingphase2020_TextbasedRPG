package com.jambit.onboarding2020.tbrpg.games.quizzes;

import java.util.ArrayList;
import java.util.List;

public class Quiz_01_Newbies implements Quizzzable {

    private int wrongAnswer1 = 5;
    private int wrongAnswer2 = 3;
    private int correctAnswer = 6;
    private String question = "Wie viele bab+lalalal";

    public List<Integer> getAnswers(){
        List<Integer> answerList = new ArrayList<>();
        answerList.add(wrongAnswer1);
        answerList.add(wrongAnswer2);
        answerList.add(correctAnswer);

        //Todo: Randomize this list

        return answerList;

    }

    @Override
    public String getQuizQuestion() {
        return question;
    }

    public boolean checkAnswer(int answer){
        if(answer == correctAnswer)
            return true;
        else
            return false;
    }

}
