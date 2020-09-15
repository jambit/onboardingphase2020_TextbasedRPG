package com.jambit.onboarding2020.tbrpg.games;

import java.util.Scanner;

public class TicTacToe {

    public void printBoard(int [][] board) {

        System.out.println(getToken(0,0, board)+" | "+getToken(0,1, board)+" | "+getToken(0,2, board));
        System.out.println("--+---+--");
        System.out.println(getToken(1,0, board)+" | "+getToken(1,1, board)+" | "+getToken(1,2, board));
        System.out.println("--+---+--");
        System.out.println(getToken(2,0, board)+" | "+getToken(2,1, board)+" | "+getToken(2,2, board));
        System.out.println();
    }

    public char getToken(int i, int j, int [][] board){
        if(board[i][j]==5)
            return 'X';

        else if(board[i][j]==2)
            return 'O';

        else
            return ' ';
    }

    private boolean whoBegins() { //random selection who get the first shot
        double ran = Math.random();

        if (ran > 0.5)
            return true; //PC starts
        else
            return false; //NPC starts
    }

    private boolean PCtip(String place, int [][] board) { //PC is 5 NPC is 2
        if (place.equals("links oben") && board[0][0] == 0) {
            board[0][0] = 5;
            return true;
        }

        else if (place.equals("links unten") && board[2][0] == 0) {
            board[2][0] = 5;
            return true;
        }

        else if (place.equals("links mitte") && board[1][0] == 0) {
            board[1][0] = 5;
            return true;
        }

        else if (place.equals("rechts oben") && board[0][2] == 0) {
            board[0][2] = 5;
            return true;
        }

        else if (place.equals("rechts unten") && board[2][2] == 0) {
            board[2][2] = 5;
            return true;
        }

        else if (place.equals("rechts mitte") && board[1][2] == 0) {
            board[1][2] = 5;
            return true;
        }

        else if (place.equals("mitte") && board[1][1] == 0) {
            board[1][1] = 5;
            return true;
        }

        else if (place.equals("oben mitte") && board[0][1] == 0) {
            board[0][1] = 5;
            return true;
        }

        else if (place.equals("unten mitte") && board[2][1] == 0) {
            board[2][1] = 5;
            return true;
        }
        else {
            Exception(board);
            return false;
        }
    }

    public void Exception(int [][] board) {
        System.out.println("Feld ist schon belegt, bitte wähle einanderes! oder ungültige Eingabe");
        Scanner scan = new Scanner(System.in);
        String place = scan.nextLine();
        PCtip(place, board);
    }


    public void NPCtip(String dificulty, int[][] board) {
        if (dificulty.equals("einfach"))
            easy(board);
        else if(dificulty.equals("mittel"))
            medium(board);
        else if (dificulty.equals(("schwer")))
            dificult(board);
        else
            System.out.println("Falsche Eingabe"); //noch anpassen!!!!
    }

    public void easy(int[][] board) { //Level 1: random, easy

        while (true) {
            int y = randomGenerator();
            int x = randomGenerator();
            if (board[x][y] == 0) {
                board[x][y] = 2;
                return;
            }
        }
    }

    public void medium(int [][] board) {

        if (tryToWin(board))
            return;
        else if (tipNear(board))
            return;
        else
            easy(board);
    }

    public void dificult(int [][] board) {
        if (tryToWin(board))
            return;
        else if(preventWinning(board)) {
            return;
        }
        else if (tipNear(board))
            return;
        else
            easy(board);
    }

    private boolean preventWinning(int[][] board) {

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == 10)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = 2;
                        return true;
                    }
        }

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == 10)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0 ) {
                        board[k][i] = 2;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == 10)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = 2;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == 10)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length-1; k >= 0; k--)
                    if (board[i][k] ==0) {
                        board[i][k] = 2;
                        return true;
                    }
        return false;
    }

    public boolean tipNear(int[][] board) {

        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[i][0] + board[i][1] + board[i][2] == 2)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = 2;
                        return true;
                    }

        for (int i = 0; i < board.length; i++)  //checks vertical
            if (board[0][i] + board[1][i] + board[2][i] == 2)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0) {
                        board[k][i] = 2;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = 2;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == 2)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length; i >= 0; i--)
                    if (board[i][k] ==0) {
                        board[i][k] = 2;
                        return true;
                    }
    return false;

    }


    public boolean tryToWin(int[][] board) { //NPC checks if he can win

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board[i][0] + board[i][1] + board[i][2] == 4)
                for (int k = 0; k < board.length; k++)
                    if (board[i][k] == 0) {
                        board[i][k] = 2;
                        return true;
                    }
        }


        for (int i = 0; i < board.length; i++)  //checks horizontal
            if (board[0][i] + board[1][i] + board[2][i] == 4)
                for (int k = 0; k < board.length; k++)
                    if (board[k][i] == 0 ) {
                        board[k][i] = 2;
                        return true;
                    }

        if (board[0][0] + board[1][1] + board[2][2] == 4)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                if (board[i][i] == 0) {
                    board[i][i] = 2;
                    return true;
                }

        if (board[0][2] + board[1][1] + board[2][0] == 4)  //checks diagonals
            for (int i = 0; i < board.length; i++)
                for (int k = board.length -1; k >= 0; k--)
                    if (board[i][k] ==0) {
                        board[i][k] = 2;
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

    public int win (int [][] board) { //-1 PC lose; 1 PC wins; 0 nobody wins;

        for (int i = 0; i < board.length; i++) { //checks vertical
            if (board [i][0] + board [i][1] + board [i][2] == 15)
                return 1;
            else if ((board [i][0] + board [i][1] + board [i][2]) == 6)
                return -1;
        }

        for (int i = 0; i < board.length; i++) { //checks horizontal
            if (board [0][i] + board [1][i] + board [2][i] == 15)
                return 1;
            else if (board [0][i] + board [1][i] + board [2][i] == 6)
                return -1;
        }

        if (board [0][0] + board [1][1] + board [2][2] == 15)  //checks diagonals
            return 1;
        else if (board [0][0] + board [1][1] + board [2][2] == 6)
            return -1;


        if (board [0][2] + board [1][1]  + board [2][0] == 15)  //checks diagonals
            return 1;
        else if (board [0][2] + board [1][1] + board [2][0] == 6)
            return -1;

        return 0;
    }

    public String getDifficulty() {

        System.out.println("Welche Schwierigkeit? Tippe einfach, mittel oder schwer");
        Scanner scanDificulty = new Scanner(System.in);
        String diff = scanDificulty.nextLine();

        while (!(diff.equals("einfach") || diff.equals("mittel") || diff.equals("schwer"))) {

            System.out.println("Falsche Eingabe! Bitte einfach, mittel oder schwer eintippen");
            Scanner scanDificulty2 = new Scanner(System.in);
            String diff2 = scanDificulty.nextLine();

            if (diff2.equals("einfach") || diff2.equals("mittel") || diff2.equals("schwer")) {
                return diff2;
            }
        }
        return diff;
    }

    public void play() {

        String dificulty = getDifficulty();

        int [][] board = new int [3][3];
        boolean whoBegins = whoBegins();

        int counter = 0;

        if (whoBegins) {

            System.out.println("Du darfst anfangen, wo setzt du dein Kreuz? Tippe links oben, links unten, links mitte, mitte, etc.");

            Scanner scaner2 = new Scanner(System.in);
            String place = scaner2.nextLine(); //player tips in first position

            PCtip(place, board);
            counter++;
        }
        else {
            System.out.println("Dein Gegner darf anfangen");
        }

        while (counter < 9) { //PC start

            NPCtip(dificulty, board); // NPC sets
            printBoard(board);
            counter++;

            if (win(board) == -1) { //check if somebody won
                printBoard(board);
                System.out.println("Du hast verloren");
                return;
            }
            else if (win(board) == 1) {
                printBoard(board);
                System.out.println("Glückwunsch, du hast gewonnen!");
                return;
            }

            System.out.println("Wo setzt du dein Kreuz? Tippe links oben, links unten, links mitte, mitte, etc.");

            Scanner scan = new Scanner(System.in);
            String place = scan.nextLine(); //player tips in first position

            PCtip(place, board);
            counter++;

            if (win(board) == -1) { //check if somebody won
                printBoard(board);
                System.out.println("Du hast verloren");
                return;
            }
            else if (win(board) == 1) {
                printBoard(board);
                System.out.println("Glückwunsch, du hast gewonnen!");
                return;
            }

            if (counter == 8) {
                System.out.println("Unentschieden!");
                return;
            }

        }

    }

}
