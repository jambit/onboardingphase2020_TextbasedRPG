package com.jambit.onboarding2020.tbrpg.utils;

public abstract class Output {

    public static void slow(String outputString) {
        for (char character : outputString.toCharArray()) {
            System.out.print(character);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                System.out.print("");
            }
        }
    }

    public static void slowIgnoreWhiteSpace(String outputString) {
        for (char character : outputString.toCharArray()) {
            if (character != ' ' || character != '\t' || character == 32) {
                System.out.print(character);
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    System.out.print("");
                }
            }
        }
    }

}
