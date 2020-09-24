package com.jambit.onboarding2020.tbrpg.games.hangman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    private String testword = "TESTWORD";

    @Test
    void guessLetter() {
        Hangman hangman = new Hangman(testword);

        boolean isGuessedRight = hangman.guessLetter('T');
        Assertions.assertTrue(isGuessedRight);

        boolean isGuessedFalse= hangman.guessLetter('X');
        Assertions.assertFalse(isGuessedFalse);
    }

    @Test
    void getKnownWord() {
        Hangman hangman = new Hangman(testword);

        char[] knownWord = hangman.getKnownWord();
        Assertions.assertFalse(knownWord.toString().isBlank());

        Assertions.assertEquals(testword.length(), hangman.getKnownWord().length);
    }

    @Test
    void guessWord() {
        Hangman hangman = new Hangman(testword);

        boolean isGuessedRight = hangman.guessWord(testword.toCharArray());

        Assertions.assertTrue(isGuessedRight);
    }
}