package com.jambit.onboarding2020.tbrpg.games;

import java.util.Scanner;

public class Quiz implements Playable{

    private String quizQuestion;
    private String quizAnswer;

    //Constructor
    public Quiz(String quizQuestion, String quizAnswer) {
        this.quizQuestion = quizQuestion;
        this.quizAnswer = quizAnswer;
    }

    //getter & setter
    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }






    @Override
    public void play() {

            }

    }

