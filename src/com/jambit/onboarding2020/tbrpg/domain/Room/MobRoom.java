package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.EnemyDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MobRoom extends AbstractRoom {


    Player player = Player.getPlayerInstance();
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> Inventory = player.getInventory();

    public void printRoomMessage() {
        System.out.println("Um weiter zu kommen musst du deinen Gegner bezwingen");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du stehst einem mächtigen Gegner gegenüber.");
    }

    @Override
    public void enter() throws PlayerDeadException {


        GameInput in = new GameInput(new InputStreamReader(System.in));
        Enemy enemy = new Enemy();
        Weapon equippedWeapon = player.getEquippedWeapon();

        System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest!" +
                "\n--------------------------" +
                "\nDein Gegner ist ein Alien... es sieht aus wie....." + enemy.getName() +
                "\n" + enemy.getAsciiArt(enemy.getName()));
        System.out.println("|Deine Lebenspunkte: " + player.getHealthState() + "|" +
        "\n|Lebenspunkte Gegner: " + enemy.getHealthState() + "|" +
        "\n|Equipped Weapon: " + player.getEquippedWeapon() + "|" +
                "\n  _     _         __ _      _   _   _ \n" +
                " | |___| |_ ___  / _(_)__ _| |_| |_| |\n" +
                " | / -_)  _(_-< |  _| / _` | ' \\  _|_|\n" +
                " |_\\___|\\__/__/ |_| |_\\__, |_||_\\__(_)\n" +
                "                      |___/           ");


      while (in.isGameRunning()) {
         System.out.println("Drücke 1) um anzugreifen oder 2) um das Pokemon zu streicheln");

            try {
                fight(in, enemy, equippedWeapon);
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
                System.out.println("Hoffentlich kommst du damit klar, ein Pokemon getötet zu haben... du Mörder!");
                in.endGame();
                itemGenerator.interactWithRoomLoot();
                return;
            }
            System.out.println("Der Gegner ist an der Reihe!");
            enemy.attack(player);
            evaluateFight(in, enemy, player);
        }

        if (input == 2) {
            if (Math.random() < 0.5) {
                System.out.println(
                        "\n                   .-.  .-.\n" +
                        "                  |   \\/   |\n" +
                        "                  \\        /\n" +
                        "                   `\\    /`\n" +
                        "                     `\\/`" +
                        "\nDas Pokemon scheint die Streicheleinheit genossen zu haben. Es greift dich nicht an!");
                evaluateFight(in, enemy, player);
            } else {
                System.out.println("Also ein Talent im Streicheln hast du schon mal nicht..." +
                        "\n Das Pokemon greift dich an!");
                enemy.attack(player);
                evaluateFight(in, enemy, player);
            }
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

