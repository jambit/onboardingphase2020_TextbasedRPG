package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.core.RoomGamesResult;

import java.util.Scanner;

public class TicTacToe {

    private final int PC_INTEGER = 5;
    private final int NPC_INTEGER = 2;
    private final int MAXIMUM_PLAYER_MOVES = 8;
    private final int[][] board = new int[3][3];

    public RoomGamesResult getGameresult () {
        return gameresult;
    }

    private RoomGamesResult gameresult;
    public Scanner scan = new Scanner(System.in);

    public void printBoard () {

        System.out.println(getToken(0, 0) + " | " + getToken(0, 1) + " | " + getToken(0, 2));
        System.out.println("--+---+--");
        System.out.println(getToken(1, 0) + " | " + getToken(1, 1) + " | " + getToken(1, 2));
        System.out.println("--+---+--");
        System.out.println(getToken(2, 0) + " | " + getToken(2, 1) + " | " + getToken(2, 2));
        System.out.println();
    }

    //muss es public sein?
    public char getToken (int i, int j) {
        if (board[i][j] == PC_INTEGER)
            return 'X';

        else if (board[i][j] == NPC_INTEGER)
            return 'O';

        else
            return ' ';
    }

    private boolean whoBegins () { //random selection who get the first shot
        double ran = Math.random();

        //NPC starts
        return ran > 0.5; //PC starts
    }

    private void pcTip (String place) { //PC is 5 NPC is 2

        if (place.equals("links oben") && board[0][0] == 0) {
            board[0][0] = PC_INTEGER;
        } else if (place.equals("links unten") && board[2][0] == 0) {
            board[2][0] = PC_INTEGER;
        } else if (place.equals("links mitte") && board[1][0] == 0) {
            board[1][0] = PC_INTEGER;
        } else if (place.equals("rechts oben") && board[0][2] == 0) {
            board[0][2] = PC_INTEGER;
        } else if (place.equals("rechts unten") && board[2][2] == 0) {
            board[2][2] = PC_INTEGER;
        } else if (place.equals("rechts mitte") && board[1][2] == 0) {
            board[1][2] = PC_INTEGER;
        } else if (place.equals("mitte") && board[1][1] == 0) {
            board[1][1] = PC_INTEGER;
        } else if (place.equals("oben mitte") && board[0][1] == 0) {
            board[0][1] = PC_INTEGER;
        } else if (place.equals("unten mitte") && board[2][1] == 0) {
            board[2][1] = PC_INTEGER;
        } else {
            exception();
        }
    }

    public void exception () {
        System.out.println("Entweder ist das Feld schon belegt, bitte wähle ein einanderes! " +
                " \nOder deine Eingabe war ungültig.");
        String place = scan.nextLine();
        pcTip(place);
    }


    public void NPCtip (String difficulty) {
        if (difficulty.equals("einfach")) {
            gameresult = RoomGamesResult.WON_EASY;
            easy();
        }
        else if (difficulty.equals("mittel")) {
            gameresult = RoomGamesResult.WON_MIDDLE;
            medium();
        }
        else if (difficulty.equals(("schwer"))) {
            gameresult = RoomGamesResult.WON_DIFFICULT;
            difficult();
        }
        else
            System.out.println("Falsche Eingabe"); //noch anpassen!!!!
    }

    public void easy () { //Level 1: random, easy

        while (true) {
            int y = randomGenerator();
            int x = randomGenerator();
            if (board[x][y] == 0) {
                board[x][y] = 2;
                return;
            }
        }
    }

    public void medium () {

        if (tryToWin())
            return;
        else if (tipNear())
            return;
        else
            easy();
    }

    public void difficult() {
        if (tryToWin())
            return;
        else if (preventWinning()) {
            return;
        } else if (tipNear())
            return;
        else
            easy();
    }

    private boolean preventWinning () {

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == PC_INTEGER * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }
        }

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == PC_INTEGER * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0) {
                        board[k][i] = NPC_INTEGER;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == PC_INTEGER * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPC_INTEGER;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == PC_INTEGER * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length - 1; k >= 0; k--)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }
        return false;
    }

    public boolean tipNear () {

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[i][0] + board[i][1] + board[i][2] == NPC_INTEGER)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }

        for (int i = 0; i < board.length; i++)  //checks vertical
            if (board[0][i] + board[1][i] + board[2][i] == NPC_INTEGER)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0) {
                        board[k][i] = NPC_INTEGER;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == NPC_INTEGER)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPC_INTEGER;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == NPC_INTEGER)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length; i >= 0; i--)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }
        return false;

    }


    public boolean tryToWin () { //NPC checks if he can win

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == NPC_INTEGER * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }
        }


        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == NPC_INTEGER * 2)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0) {
                        board[k][i] = NPC_INTEGER;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == NPC_INTEGER * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = NPC_INTEGER;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == NPC_INTEGER * 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length - 1; k >= 0; k--)
                    if (board[i][k] == 0) {
                        board[i][k] = NPC_INTEGER;
                        return true;
                    }
        return false;
    }

    // TODO: 24.09.2020 die folgende Methode entspricht random.nextInt(3)
    public int randomGenerator () {
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
            if (board[i][0] + board[i][1] + board[i][2] == PC_INTEGER * 3)
                return 1;
            else if ((board[i][0] + board[i][1] + board[i][2]) == NPC_INTEGER * 3)
                return -1;
        }

        for (int i = 0; i < board.length; i++) { //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == PC_INTEGER * 3)
                return 1;
            else if (board[0][i] + board[1][i] + board[2][i] == NPC_INTEGER * 3)
                return -1;
        }

        if (board[0][0] + board[1][1] + board[2][2] == PC_INTEGER * 3)  //checks diagonals
            return 1;
        else if (board[0][0] + board[1][1] + board[2][2] == NPC_INTEGER * 3)
            return -1;


        if (board[0][2] + board[1][1] + board[2][0] == PC_INTEGER * 3)  //checks diagonals
            return 1;
        else if (board[0][2] + board[1][1] + board[2][0] == NPC_INTEGER * 3)
            return -1;

        return 0;
    }

    public String getDifficulty () {

        System.out.println();
        System.out.println("Welche Schwierigkeit? Tippe:" +
                "\n [einfach] [mittel] [schwer]");
        String diff = scan.nextLine();

        while (!(diff.equals("einfach") || diff.equals("mittel") || diff.equals("schwer"))) {
            System.out.println("Falsche Eingabe! Bitte [einfach] [mittel] [schwer] eintippen");
            diff = scan.nextLine();
        }
        return diff;
    }

    public boolean play () {

        String difficulty = getDifficulty();

        int PlayerMovesCounter = 0;

        if (whoBegins()) {

            System.out.println("Du darfst anfangen, wo setzt du dein Kreuz? Tippe: " +
                    "\n [links oben] [oben mitte] [rechts oben]" +
                    "\n [links mitte] [mitte] [rechts mitte]" +
                    "\n [links unten] [unten mitte] [rechts unten]");
            printBoard();
            String place = scan.nextLine(); //player tips in first position
            pcTip(place);
            PlayerMovesCounter++;
        } else {
            System.out.println("Dein Gegner darf anfangen");
        }
        while (PlayerMovesCounter <= MAXIMUM_PLAYER_MOVES) { //PC start

            NPCtip(difficulty); // NPC sets
            printBoard();
            PlayerMovesCounter++;

            if (endsGameIfWon()) {
                return false;
            }

            System.out.println("Wo setzt du dein Kreuz? Tippe: " +
                    "\n [links oben] [oben mitte] [rechts oben]" +
                    "\n [links mitte] [mitte] [rechts mitte]" +
                    "\n [links unten] [unten mitte] [rechts unten]");
            String place = scan.nextLine(); //player tips in first position

            pcTip(place);
            PlayerMovesCounter++;

            if (endsGameIfWon()) {
                return false;
            }

            if (PlayerMovesCounter >= MAXIMUM_PLAYER_MOVES) {
                System.out.println("Unentschieden! Du darfst nochmal spielen");
                TicTacToe tieTicTacToe = new TicTacToe();
                tieTicTacToe.play();
                return true;
            }
        }
        return true;
    }

    public boolean endsGameIfWon () {
        if (win() == -1) { //check if somebody won
            printBoard();
            System.out.println("Du hast verloren");
            gameresult = RoomGamesResult.LOST;
            return true;

        } else if (win() == 1) {
            printBoard();
            System.out.println("Glückwunsch, du hast gewonnen!");
            return true;
        }
        return false;
    }

}
