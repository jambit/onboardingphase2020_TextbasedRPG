package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.games.quizzes.Quiz_01_Newbies;
import com.jambit.onboarding2020.tbrpg.games.quizzes.Quizzzable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaster implements Playable {

    @Override
    public void play() {

        System.out.println("Mein Name ist Günther Jauch...");
        ArrayList<Quizzzable> quizList = new ArrayList<>();
        quizList.add(new Quiz_01_Newbies());
        quizList.add(new Quiz_01_Newbies());
        quizList.add(new Quiz_01_Newbies());
        quizList.add(new Quiz_01_Newbies()); // add more quizzes with more questions

        for (Quizzzable quiz : quizList) {
            System.out.println("Frage: " + quiz.getQuizQuestion());
            List<Integer> answers = quiz.getAnswers();
            System.out.println("A: [" + answers.get(0) + "]");
            System.out.println("B: [" + answers.get(1) + "]");
            System.out.println("C: [" + answers.get(2) + "]");

            //while loop and check with user input
            // if correct then leave
            // if not, repeat


        }


    }

}

