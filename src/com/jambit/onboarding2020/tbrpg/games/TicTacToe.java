package com.jambit.onboarding2020.tbrpg.games;

import java.util.Scanner;

public class TicTacToe {

    private final int PCinteger = 5;
    private final int NPCinteger = 2;
    private int [][] board = new int [3][3];

    public void printBoard() {

        System.out.println(getToken(0,0)+" | "+getToken(0,1)+" | "+getToken(0,2));
        System.out.println("--+---+--");
        System.out.println(getToken(1,0)+" | "+getToken(1,1)+" | "+getToken(1,2));
        System.out.println("--+---+--");
        System.out.println(getToken(2,0)+" | "+getToken(2,1)+" | "+getToken(2,2));
        System.out.println();
    }

    //muss es public sein?
    public char getToken(int i, int j){
        if(board[i][j] == PCinteger)
            return 'X';

        else if(board[i][j] == NPCinteger)
            return 'O';

        else
            return ' ';
    }
    //Todo: ein passenderer Name wäre: getRandomTrueFalse(), von einem Spieler muss die Methode ja nichts wissen. Oder?
    private boolean whoBegins() { //random selection who get the first shot
        double ran = Math.random();

         if (ran > 0.5)
            return true; //PC starts
        else
            return false; //NPC starts
    }

    private void pcTip(String place) { //PC is 5 NPC is 2

        if (place.equals("links oben") && board[0][0] == 0) {
            board[0][0] = PCinteger;
        }

        else if (place.equals("links unten") && board[2][0] == 0) {
            board[2][0] = PCinteger;
        }

        else if (place.equals("links mitte") && board[1][0] == 0) {
            board[1][0] = PCinteger;
        }

        else if (place.equals("rechts oben") && board[0][2] == 0) {
            board[0][2] = PCinteger;
        }

        else if (place.equals("rechts unten") && board[2][2] == 0) {
            board[2][2] = PCinteger;
        }

        else if (place.equals("rechts mitte") && board[1][2] == 0) {
            board[1][2] = PCinteger;
        }

        else if (place.equals("mitte") && board[1][1] == 0) {
            board[1][1] = PCinteger;
        }

        else if (place.equals("oben mitte") && board[0][1] == 0) {
            board[0][1] = PCinteger;
        }

        else if (place.equals("unten mitte") && board[2][1] == 0) {
            board[2][1] = PCinteger;
        }
        else {
            exception();
        }
    }

    public void exception () {
        System.out.println("Feld ist schon belegt, bitte wähle einanderes! oder ungültige Eingabe");
        Scanner scan = new Scanner(System.in);
        String place = scan.nextLine();
        pcTip(place);
    }


    public void NPCtip(String dificulty) {
        if (dificulty.equals("einfach"))
            easy();
        else if(dificulty.equals("mittel"))
            medium();
        else if (dificulty.equals(("schwer")))
            dificult();
        else
            System.out.println("Falsche Eingabe"); //noch anpassen!!!!
    }

    public void easy() { //Level 1: random, easy

        while (true) {
            int y = randomGenerator();
            int x = randomGenerator();
            if (board[x][y] == 0) {
                board[x][y] = 2;
                return;
            }
        }
    }

    public void medium() {

        if (tryToWin())
            return;
        else if (tipNear())
            return;
        else
            easy();
    }

    public void dificult() {
        if (tryToWin())
            return;
        else if(preventWinning()) {
            return;
        }
        else if (tipNear())
            return;
        else
            easy();
    }

    private boolean preventWinning() {

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == PCinteger * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }
        }

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == PCinteger * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0 ) {
                        board[k][i] = NPCinteger;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == PCinteger * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPCinteger;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == PCinteger * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length-1; k >= 0; k--)
                    if (board[i][k] ==0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }
        return false;
    }

    public boolean tipNear() {

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[i][0] + board[i][1] + board[i][2] == NPCinteger)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }

        for (int i = 0; i < board.length; i++)  //checks vertical
            if (board[0][i] + board[1][i] + board[2][i] == NPCinteger)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0) {
                        board[k][i] = NPCinteger;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == NPCinteger)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPCinteger;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == NPCinteger)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length; i >= 0; i--)
                    if (board[i][k] ==0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }
    return false;

    }


    public boolean tryToWin() { //NPC checks if he can win

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == NPCinteger * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }
        }


        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == NPCinteger * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0 ) {
                        board[k][i] = NPCinteger;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == NPCinteger * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPCinteger;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == NPCinteger * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length -1; k >= 0; k--)
                    if (board[i][k] ==0) {
                        board[i][k] = NPCinteger;
                        return true;
                    }
        return false;
    }



    public int randomGenerator() {
        double random = Math.random();

        if (random < 0.33)
            random = 0;
        else if (random > 0.66)
            random = 1;
        else
            random = 2;

        int random2 = (int) random;

        return random2;
    }

    public int win () { //-1 PC lose; 1 PC wins; 0 nobody wins;

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board [i][0] + board [i][1] + board [i][2] == PCinteger * 3)
                return 1;
            else if ((board [i][0] + board [i][1] + board [i][2]) == NPCinteger * 3)
                return -1;
        }

        for (int i = 0; i < board.length; i++) { //checks horizontal
            if (board [0][i] + board [1][i] + board [2][i] == PCinteger * 3)
                return 1;
            else if (board [0][i] + board [1][i] + board [2][i] == NPCinteger * 3)
                return -1;
        }
^
        if (board [0][0] + board [1][1] + board [2][2] == PCinteger * 3)  //checks diagonals
            return 1;
        else if (board [0][0] + board [1][1] + board [2][2] == NPCinteger * 3)
            return -1;


        if (board [0][2] + board [1][1]  + board [2][0] == PCinteger * 3)  //checks diagonals
            return 1;
        else if (board [0][2] + board [1][1] + board [2][0] == NPCinteger * 3)
            return -1;

        return 0;
    }

    public String getDifficulty() {

        System.out.println("Welche Schwierigkeit? Tippe einfach, mittel oder schwer");
        Scanner scanDificulty = new Scanner(System.in);
        String diff = scanDificulty.nextLine();

        while (!(diff.equals("einfach") || diff.equals("mittel") || diff.equals("schwer"))) {
            System.out.println("Falsche Eingabe! Bitte einfach, mittel oder schwer eintippen");
            diff = scanDificulty.nextLine();
        }
        return diff;
    }

    public void play() {

        String dificulty = getDifficulty();

        int counter = 0;

        if (whoBegins()) {

            System.out.println("Du darfst anfangen, wo setzt du dein Kreuz? Tippe links oben, links unten, links mitte, mitte, etc.");
            //Scaner2 ist ein suboptimaler Variablenname. Was spricht gegen "scanner"?
            Scanner scaner2 = new Scanner(System.in);
            String place = scaner2.nextLine(); //player tips in first position
            //Todo: Ihr könnt die oberen zwei Zeilen in eine Methode auslagern und direkt im Parameter von PCtip aufrufen. Bspw. getPlayerMove
            pcTip(place);
            counter++;
        }
        else {
            System.out.println("Dein Gegner darf anfangen");
        }
        // Todo: Anstelle von Zahlen zu verwenden wäre es cool, wenn ihr eine Konstante einführt. Bspw. MAXIMUM_PLAYER_MOVES
        //  und die Variable counter in "playerMoveCounter" umbenennen. Dann liest es sich einfacher. :)
        while (counter < 9) { //PC start
            // Todo: same here: boord als parameter könnt ihr euch sparen, wenn ihr es als Klassenvariable deklariert
            NPCtip(dificulty); // NPC sets
            printBoard();
            counter++;

            if (win() == -1) { //check if somebody won
                printBoard();
                System.out.println("Du hast verloren");
                return;
            }
            else if (win() == 1) {
                printBoard();
                System.out.println("Glückwunsch, du hast gewonnen!");
                return;
            }

            System.out.println("Wo setzt du dein Kreuz? Tippe links oben, links unten, links mitte, mitte, etc.");

            //Todo: WEnn ihr das Scannerobjekt als Klassenvariable deklariert, könnt ihr es überall in der Klasse nutzen.
            // Das ist vollkommen in Ordnung. :)
            Scanner scan = new Scanner(System.in);
            String place = scan.nextLine(); //player tips in first position

            pcTip(place);
            counter++;

            //Todo: Das ist der gleiche Code wie in Zeilen 345-354 --> ein eigene Methode bietet sich an
            if (win() == -1) { //check if somebody won
                printBoard();
                System.out.println("Du hast verloren");
                return;
            }
            else if (win() == 1) {
                printBoard();
                System.out.println("Glückwunsch, du hast gewonnen!");
                return;
            }

            if (counter == 8) {  // TODO: 16.09.2020 Untenschieden sometimes doesn´t work 
                System.out.println("Unentschieden!");
                return;
            }

        }

    }

}
