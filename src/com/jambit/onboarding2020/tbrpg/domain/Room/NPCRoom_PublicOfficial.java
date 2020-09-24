package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.games.sentenceGenerator.MarkovChain;
import com.jambit.onboarding2020.tbrpg.utils.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class NPCRoom_PublicOfficial extends AbstractRoom {

    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printRoomMessage() {
        System.out.println("Der nächste Raum wirkt ungefährlich... Du hörst leises Murmeln durch die Tür. ");

    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du triffst auf ein menschlich aussehendes Wesen, das dir den Weiterweg blockiert.");
        System.out.println("Es sieht nicht gefährlich aus, nur etwas verwirrt. Sein an den Kragen gestecktes Schildchen" +
                "\nweist es als einen Beamten des galaktischen Verwaltungsfachgremiums aus:");
        System.out.println("\n" +
                "  (¯`·.¸¸.·´¯`·.¸¸.·´¯)\n" +
                "  ( \\                 / )\n" +
                " ( \\ )  BEAMTER des  ( / )\n" +
                "  ) (  >galVerFaGre<  ) ( \n" +
                " ( / )               ( \\ )\n" +
                "  ( /  nicht füttern  \\ )\n" +
                "   (_.·´¯`·.¸¸.·´¯`·.¸_)\n" +
                "   \n" +
                "   ");    }

    @Override
    public void enter() {

        Random random = new Random();
        ItemGenerator itemGenerator = new ItemGenerator();

        ArrayList<String> smallTalkList = new ArrayList<>();
        smallTalkList.add(">>Sehr interessant. Ich müsste dann mal...<<");
        smallTalkList.add(">>Da stimme ich Ihnen voll zu. Dürfte ich kurz...<<");
        smallTalkList.add(">>So habe ich das noch nie betrachtet. Übrigens, ich müsste hier kurz...<<");
        smallTalkList.add(">>Absolut. Nur muss ich grade...<<");
        smallTalkList.add(">>... ja, ja, aber könnten Sie bitte...");




        System.out.print("Mit weit aufgerissenen Augen murmelt er vor sich hin: \n\n>>...");
        printRandomSentence();
        System.out.println("...<<\n");
        System.out.println("Du musst hier vorbei. Vielleicht kannst du die Gestalt ansprechen[A] und zum Gehen bewegen?");

        String line = "";

        line = getInputStringFromPlayer(line);
        int talkCount = 0;
        while (talkCount != 3) {


            if ((line.equalsIgnoreCase("ansprechen") || line.equalsIgnoreCase("A")) && talkCount == 0) {
                talkCount = printFirstTry(random, smallTalkList, talkCount);
                line = getInputStringFromPlayer(line);

            } else if ((line.equalsIgnoreCase("ansprechen") || line.equalsIgnoreCase("A")) && talkCount == 1) {
                talkCount = printSecondTry(random, smallTalkList, talkCount);
                line = getInputStringFromPlayer(line);

            } else if ((line.equalsIgnoreCase("ansprechen") || line.equalsIgnoreCase("A")) && talkCount == 2) {
                talkCount = printThirdTry(random, smallTalkList, talkCount);
                line = getInputStringFromPlayer(line);
            } else {
                System.out.println("Du kommst noch nicht aus dem Raum. Vielleicht kannst du die Gestalt ansprechen[A]?");
                line = getInputStringFromPlayer(line);
            }
        }
        System.out.println("Endlich dreht sich die Gestalt weg und du kannst weiter gehen.");
        Output.slow("                                                           \n");
        itemGenerator.interactWithRoomLoot();
    }

    private int printFirstTry(Random random, ArrayList<String> smallTalkList, int talkCount) {
        System.out.println("Du sagst: " + smallTalkList.get(random.nextInt(smallTalkList.size())));
        System.out.print("Der Beamte starrt an dir vorbei und murmelt: \n\n>>...");
        printRandomSentence();
        System.out.println("...<<\n");

        System.out.println("Er macht keine Anstalten, sich zu bewegen.");
        System.out.println("Vielleicht kannst du es noch einmal versuchen?");
        talkCount = 1;
        return talkCount;
    }

    private int printSecondTry(Random random, ArrayList<String> smallTalkList, int talkCount) {
        System.out.println("Du versuchst es mit: " + smallTalkList.get(random.nextInt(smallTalkList.size())));
        System.out.print("Der Beamte zuckt kurz und murmelt dann: \n\n>>...");
        printRandomSentence();
        System.out.println("...<<\n");

        System.out.println("Er bewegt sich nicht, aber du bist dir sicher, dass er dich hören kann.");
        System.out.println("Vielleicht kannst du es noch einmal versuchen?");
        talkCount = 2;
        return talkCount;
    }

    private int printThirdTry(Random random, ArrayList<String> smallTalkList, int talkCount) {
        System.out.println("Du murmelst: " + smallTalkList.get(random.nextInt(smallTalkList.size())));
        System.out.print("Der Beamte sieht dich kurz an und schaut dann wieder auf dem Boden," +
                "\nwährend er erklärt: \n\n>>...");
        printRandomSentence();
        System.out.println("...<<\n");

        System.out.println("Du bist fast zu ihm durchgedrungen.");
        System.out.println("Vielleicht kannst du es noch einmal versuchen?");
        talkCount = 3;
        return talkCount;
    }



    private String getInputStringFromPlayer(String line) {
        try {
            line = "";
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void printRandomSentence() {
        MarkovChain markovChain = new MarkovChain();
        try { //filePath has to be the complete Path from /src.../whatever.txt
            // otherwise Files.readAllBites throws an FileNotFoundException
            System.out.print(markovChain.markov("src/com/jambit/onboarding2020/tbrpg/games/sentenceGenerator/administrativeLaw.txt",
                    3, 15));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

