package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.games.sentenceGenerator.MarkovChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NPCRoom extends AbstractRoom {

    //MarkovChain markovChain = new MarkovChain();
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printRoomMessage() {
        super.printRoomMessage();
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Der nächste Raum wirkt ungefährlich");
    }

    @Override
    public void enter() {

        System.out.println("Du triffst einen etwas verwirrt aussehenden NPC!");

        String line = "";
        while (!line.equalsIgnoreCase("verlassen")) {
            if (line.equalsIgnoreCase("ansprechen")) {
                System.out.print("Der NPC starrt an dir vorbei und murmelt: >>...");
                MarkovChain.printRandomSentence();
                System.out.println("...<<");
                line = "";
            } else {
                System.out.println("Möchtest du den NPC [ansprechen] oder den Raum [verlassen]?");
                try {
                    line = "";
                    line = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

