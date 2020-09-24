package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Player.*;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BossRoom extends AbstractRoom {

    Boss boss = new Boss();
    Player player = Player.getPlayerInstance();
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> Inventory = player.getInventory();
    int bossDamage = boss.getAttackDamage();

    public void printRoomMessage() {
        System.out.println("Um weiter zu kommen musst du deinen Gegner bezwingen");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du stehst einem mächtigen Gegner gegenüber.");
    }


    public void enter() throws PlayerDeadException {


        GameInput in = new GameInput(new InputStreamReader(System.in));

        Weapon equippedWeapon = player.getEquippedWeapon();

        printWelcomeMessage();
        System.out.println("\n--------------------------" +
                "     __.,,------.._\n" +
                        "      ,'\"   _      _   \"`.\n" +
                        "     /.__, ._  -=- _\"`    Y\n" +
                        "    (.____.-.`      \"\"`   j\n" +
                        "     VvvvvvV`.Y,.    _.,-'       ,     ,     ,\n" +
                        "        Y    ||,   '\"\\         ,/    ,/    ./\n" +
                        "        |   ,'  ,     `-..,'_,'/___,'/   ,'/   ,\n" +
                        "   ..  ,;,,',-'\"\\,'  ,  .     '     ' \"\"' '--,/    .. ..\n" +
                        " ,'. `.`---'     `, /  , Y -=-    ,'   ,   ,. .`-..||_|| ..\n" +
                        "ff\\\\`. `._        /f ,'j j , ,' ,   , f ,  \\=\\ Y   || ||`||_..\n" +
                        "l` \\` `.`.\"`-..,-' j  /./ /, , / , / /l \\   \\=\\l   || `' || ||...\n" +
                        " `  `   `-._ `-.,-/ ,' /`\"/-/-/-/-\"'''\"`.`.  `'.\\--`'--..`'_`' || ,\n" +
                        "            \"`-_,',  ,'  f    ,   /      `._    ``._     ,  `-.`'//         ,\n" +
                        "          ,-\"'' _.,-'    l_,-'_,,'          \"`-._ . \"`. /|     `.'\\ ,       |\n" +
                        "        ,',.,-'\"          \\=) ,`-.         ,    `-'._`.V |       \\ // .. . /j\n" +
                        "        |f\\\\               `._ )-.\"`.     /|         `.| |        `.`-||-\\\\/\n" +
                        "        l` \\`                 \"`._   \"`--' j          j' j          `-`---'\n" +
                        "         `  `                     \"`,-  ,'/       ,-'\"  /\n" +
                        "                                 ,'\",__,-'       /,, ,-'\n" +
                        "                                 Vvv'            VVv'" +
                "\nICH BIN ASH! DU HAST MEINE POKEMON GETÖTET! ICH WERDE DICH UMBRINGEN!");
        System.out.println("|Deine Lebenspunkte: " + player.getHealthState() + "|" +
                "\n|Lebenspunkte Ash: " + boss.getHealthState() + "|" +
                "\n|Equipped Weapon: " + player.getEquippedWeapon() + "|" +
                "█     ▄███▄     ▄▄▄▄▀ ▄▄▄▄▄       ▄████  ▄█   ▄▀   ▄  █    ▄▄▄▄▀ \n" +
                "█     █▀   ▀ ▀▀▀ █   █     ▀▄     █▀   ▀ ██ ▄▀    █   █ ▀▀▀ █    \n" +
                "█     ██▄▄       █ ▄  ▀▀▀▀▄       █▀▀    ██ █ ▀▄  ██▀▀█     █    \n" +
                "███▄  █▄   ▄▀   █   ▀▄▄▄▄▀        █      ▐█ █   █ █   █    █     \n" +
                "    ▀ ▀███▀    ▀                   █      ▐  ███     █    ▀      \n" +
                "                                    ▀               ▀            ");


        while (in.gameState()) {
            System.out.println("Drücke [1] um anzugreifen oder [2] um Ash zu streicheln?!");

            try {
                fight(in, boss, equippedWeapon);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }


        }
    }

    private void fight(GameInput in, Enemy enemy, Weapon equippedWeapon) throws InvalidInputException, PlayerDeadException {
        int input = in.inputInteger();
        ItemGenerator itemGenerator = new ItemGenerator();

        if (input == 1) {
            try {
                player.attack(enemy, equippedWeapon);
            } catch (EnemyDeadException e) {
                System.out.println(e.getMessage());
                System.out.println("Endlich frei!!");
                in.winGame();
                itemGenerator.interactWithRoomLoot();
                return;
            }
            System.out.println("Der Gegner ist an der Reihe!");
            enemy.attack(player);
            evaluateFight(in, enemy, player);
        }

        if (input == 2) {
            System.out.println("HAST DU GERADE ERNSTHAFT VERSUCHT MICH ZU STREICHELN?! DU MICKRIGER MENSCH HAHAHA" +
                    "\n_____________________________________________" +
                    "\nDu hast Ash aggressiv gemacht! Er wird noch stärker und greift dich an!");
            player.decreaseHealthState((int)0.5*player.getHealthState());
            bossDamage = bossDamage + 10;
            }
        }


    private void evaluateFight(GameInput in, Enemy enemy, Player player) {
        System.out.println("|Lebenspunkte des Spielers: " + Player.getPlayerInstance().getHealthState() + "|");
        System.out.println("|Lebenspunkte des Gegners: " + enemy.getHealthState() + "|");
        chooseItem(player);
        System.out.println("               _                          _ \n" +
                "  _ _  _____ _| |_   _ _ ___ _  _ _ _  __| |\n" +
                " | ' \\/ -_) \\ /  _| | '_/ _ \\ || | ' \\/ _` |\n" +
                " |_||_\\___/_\\_\\\\__| |_| \\___/\\_,_|_||_\\__,_|");
    }

    private void chooseItem(Player player) {
        System.out.println("Möchstest du ein Item einsetzen? " +
                "\n Wenn ja, tippe Heiltrank [ht] oder Fluchtseil [fs]" +
                "\n ansonsten, tippe Nein [n]");

        String input = scan.nextLine();
        while (!(input.equalsIgnoreCase("Heiltrank")) && !(input.equalsIgnoreCase("ht"))
                && !(input.equalsIgnoreCase("Fluchtseil")) && !(input.equalsIgnoreCase("fs"))
                && !(input.equalsIgnoreCase("nein")) && !(input.equalsIgnoreCase("n"))) {
            System.out.println("Falsche Eingabe, bitte erneut eintippen");
            input = scan.nextLine();
        }

        if (input.equalsIgnoreCase("Heiltrank") || input.equalsIgnoreCase("ht")) {
            if (Inventory.size() == 0)
                System.out.println("Dein Inventar ist leer!");
            else if (checkHealthPotion()) {
                System.out.println("Du setzt einen Heiltrank ein");
                player.getConsumableFromInventory("Heiltrank").consume();
            } else {
                System.out.println("Du hast keinen Heiltrank!");
            }
        }


        if (input.equalsIgnoreCase("Fluchtseil") || input.equalsIgnoreCase("fs")) {
            if (Inventory.size() == 0)
                System.out.println("Dein Inventar ist leer!");
            else if (checkEscRope()) {
                System.out.println("Du setzt ein Fluchtseil ein!");
                skip();
                player.takeItemFromInventory("Fluchtseil");
                player.getConsumableFromInventory("Fluchtseil").consume();
            } else {
                System.out.println("Du hast kein Fluchtseil!");

            }
        }

        if (input.equalsIgnoreCase("nein") || input.equalsIgnoreCase("n"))
            return;
    }




    public boolean checkEscRope() {
        for (Item i : Inventory) {
            if (i.getName().equalsIgnoreCase("Fluchtseil")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHealthPotion() {
        for (Item i : Inventory) {
            if (i.getName().equalsIgnoreCase("Heiltrank")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void skip() {
        System.out.println("Feigling...du überspringst den Raum.");


    }
}


