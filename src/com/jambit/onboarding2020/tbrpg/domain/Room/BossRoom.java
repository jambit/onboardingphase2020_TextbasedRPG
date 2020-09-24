package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Player.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BossRoom extends AbstractRoom {
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Boss boss = new Boss();
    Player player = Player.getPlayerInstance();
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> Inventory = player.getInventory();
    int bossDamage = boss.getAttackDamage();

    public void printRoomMessage() {
        System.out.println("\n" +
                "Endlich! Du stehst vor der Tür des zuständigen Sachbearbeiters. \n" +
                "Hinter dieser Tür wartet dein Passierschein auf dich... dein Weg zurück nach Hause... Freiheit.");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du stehst in einem großzügigen Büro (mit Fenstern!) und blickst auf einen Schreibtisch, hinter dem\n" +
                "eine kleine, untersetzte Gestalt sitzt.\n" +
                "\n" +
                "    |`.             /\n" +
                "    | \\`.          / |\n" +
                "    |  \\ \\.------./ '|\n" +
                "    |  .'          / |\n" +
                "    |  |             |\n" +
                "    \\  |  ___ ' __  /\n" +
                "     \\  \\ `0 ) /0 //\n" +
                "      `--\\    v  /-\n" +
                "         /\\ -  /\n" +
                "      .--. '---'_\n" +
                "     /      ./ //-\n" +
                "    /       .-'/- \\\n" +
                "    /    -      \\__|\n" +
                "   /     -       )_|\n" +
                "  __________________________________\n" +
                "\t\t\t\t\t\t\t\t   /\n" +
                "\t\t\t\t\t\t\t\t  /\n" +
                "\t\t\t\t\t\t\t\t /\n" +
                "  ______________________________/");
    }


    public void enter() throws PlayerDeadException {
        String line = "";

        System.out.println("Du stürzt in den Raum, deine Waffe fest umklammert.\n" +
                ">>ICH WILL DIESEN ..@%&§ PASSIERSCHEIN!<<\n" +
                "Der Beamte schaut dich entsetzt, aber wortlos, an.\n" +
                ">>Ich bin durch diese Behörde gerannt... Raum für Raum... vorbei an verrückten Aliens,\n" +
                "kinderfressenden Reptiloiden, TicTacToe-Verrückten, verwirrten Beamten... und POKEMONS!\n" +
                "Ich. will. diesen. Passierschein!!<<\n" +
                "Der Alien-Beamte scheint über dein Auftreten nicht begeistert zu sein.\n" +
                ">>Ja, haben Sie denn die notwenigen Formulare eingereicht?<<\n" +
                "\n" +
                "Willst du lügen[l] oder den Alien-Beamten bedrohen[b]?");

        interactWithFirstBoss(line);



        GameInput in = new GameInput(new InputStreamReader(System.in));

        Weapon equippedWeapon = player.getEquippedWeapon();


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
                "\n█     ▄███▄     ▄▄▄▄▀ ▄▄▄▄▄       ▄████  ▄█   ▄▀   ▄  █    ▄▄▄▄▀ \n" +
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

    private void fight(GameInput in, Boss boss, Weapon equippedWeapon) throws InvalidInputException, PlayerDeadException {
        int input = in.inputInteger();
        ItemGenerator itemGenerator = new ItemGenerator();


        if (input == 1) {
            try {
                player.attackBoss(boss, equippedWeapon);
            } catch (EnemyDeadException e) {
                System.out.println(e.getMessage());
                System.out.println("Endlich frei!!");
                in.winGame();
                itemGenerator.interactWithRoomLoot();
                return;
            }
            System.out.println("Der Gegner ist an der Reihe!");
            boss.attack(player);
            evaluateFight(in, boss, player);
        }

        if (input == 2) {
            System.out.println("HAST DU GERADE ERNSTHAFT VERSUCHT MICH ZU STREICHELN?! DU MICKRIGER MENSCH HAHAHA" +
                    "\n_____________________________________________" +
                    "\nDu hast Ash aggressiv gemacht! Er wird noch stärker und greift dich an!");
            player.decreaseHealthState((int)(0.5 * player.getHealthState()));
            bossDamage = bossDamage + 10;
            evaluateFight(in, boss, player);
            }
        }


    private void evaluateFight(GameInput in, Boss boss, Player player) {
        System.out.println("|Lebenspunkte des Spielers: " + Player.getPlayerInstance().getHealthState() + "|");
        System.out.println("|Lebenspunkte von Ash: " + boss.getHealthState() + "|");
        chooseItem(player);
        System.out.println(" ▐ ▄ ▄▄▄ .▐▄• ▄ ▄▄▄▄▄    ▄▄▄        ▄• ▄▌ ▐ ▄ ·▄▄▄▄  \n" +
                "•█▌▐█▀▄.▀· █▌█▌▪•██      ▀▄ █·▪     █▪██▌•█▌▐███▪ ██ \n" +
                "▐█▐▐▌▐▀▀▪▄ ·██·  ▐█.▪    ▐▀▀▄  ▄█▀▄ █▌▐█▌▐█▐▐▌▐█· ▐█▌\n" +
                "██▐█▌▐█▄▄▌▪▐█·█▌ ▐█▌·    ▐█•█▌▐█▌.▐▌▐█▄█▌██▐█▌██. ██ \n" +
                "▀▀ █▪ ▀▀▀ •▀▀ ▀▀ ▀▀▀     .▀  ▀ ▀█▄▀▪ ▀▀▀ ▀▀ █▪▀▀▀▀▀• ");
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


    private void interactWithFirstBoss(String line) {
        line = getInputStringFromPlayer(line);
        while (!line.equalsIgnoreCase("B") && !line.equalsIgnoreCase("bedrohen")) {
            if (line.equalsIgnoreCase("L") || line.equalsIgnoreCase("lügen")) {
                System.out.println(">>Natürlich habe ich die richtigen Formulare eingereicht! Schon vor Monaten!<<\n" +
                        "Der Alien-Beamte tippt etwas in sein Terminal.\n" +
                        ">>Nein, ich kann hier keinen aktuellen Antrag auf Heimführung finden... \n" +
                        "außerdem ist jetzt Mittagspause... kommen Sie gegen zwei wieder her.<<\n" +
                        "\n" +
                        "Die Aussage macht dich unsagbar wütend. Eins ist sicher: du wartest nicht darauf,\n" +
                        "dass die langsamen Mühlen der Bürokratie dich wieder nach Hause bringen.\n" +
                        "Gewalt ist hier die naheliegende Lösung.");

                return;

            } else if (!line.equalsIgnoreCase("l") && !line.equalsIgnoreCase("lügen")
                    && !line.equalsIgnoreCase("b") && !line.equalsIgnoreCase("bedrohen")) {
                System.out.println("Es gibt keine anderen Möglichkeiten\n" +
                        "Willst du lügen[l] oder den Alien-Beamten bedrohen[b]?");
            }

        }
        if (line.equalsIgnoreCase("b") || line.equalsIgnoreCase("bedrohen")) {
            System.out.println("Natürlich: Gewalt ist immer die Lösung!");
            return;
        }
    }

    private String getInputStringFromPlayer (String line){
        try {
            line = "";
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}


