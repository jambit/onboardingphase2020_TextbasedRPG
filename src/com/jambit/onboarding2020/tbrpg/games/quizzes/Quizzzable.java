package com.jambit.onboarding2020.tbrpg.games.quizzes;

import java.util.List;

public interface Quizzzable {

    public List<Integer> getAnswers();

    public String getQuizQuestion();

    public boolean checkAnswer(int answer);

}
