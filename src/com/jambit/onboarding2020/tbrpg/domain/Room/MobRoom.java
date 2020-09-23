package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Items.HealthPotion;
import com.jambit.onboarding2020.tbrpg.domain.Items.Item;
import com.jambit.onboarding2020.tbrpg.domain.Items.Weapon;
import com.jambit.onboarding2020.tbrpg.domain.Players.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Players.EnemyDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Players.Player;
import com.jambit.onboarding2020.tbrpg.domain.Players.PlayerDeadException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MobRoom extends AbstractRoom {


    Player player = Player.getPlayerInstance();
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> Inventory = player.getInventory();

    public void printRoomMessage() {
        System.out.println("Um weiter zu kommen musst du einen Gegner bezwingen");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du stehst einem mächtigen Gegner gegenüber.");
    }

    @Override
    public void enter() throws PlayerDeadException {


        GameInput in = new GameInput(new InputStreamReader(System.in));
        Enemy enemy = new Enemy(); // Name übergeben von Enemy
        Random random = new Random();
        Weapon equippedWeapon = player.getEquippedWeapon();

        System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest");
        System.out.println("Health State Player: " + player.getHealthState());
        System.out.println("Health State Enemy: " + enemy.getHealthState());
        System.out.println("Equipped Weapon: " + player.getEquippedWeapon());


        while (in.gameState()) {
            System.out.println("Drücke 1) um anzugreifen oder 2) um zu verteidigen.");

            try {
                fight(in, enemy, equippedWeapon);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }

            evaluateFight(in, enemy, player);

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
                in.winGame();
                itemGenerator.interactWithRoomLoot();
                return;
            }
            System.out.println("Der Gegner ist an der Reihe!");
            enemy.attack(player);
        }

        if (input == 2) {
            if (Math.random() < 0.5)
                System.out.println("Dein Abwehrversuch war erfolgreich!");
            else {
                System.out.println("Also diese Abwehr ist ja mehr als lächerlich... " +
                        "\n Dein Gegner ist nicht gerade begeistert und greift an!");
                enemy.attack(player);
            }
        }
    }


    private void evaluateFight(GameInput in, Enemy enemy, Player player) {
        System.out.println("Lebenspunkte des Spielers: " + Player.getPlayerInstance().getHealthState());
        System.out.println("Lebenspunkte des Gegners: " + enemy.getHealthState());
        chooseItem(player);
    }

    private void chooseItem(Player player) {
        System.out.println("Möchstest du ein Item einsetzen? " +
                "\n Wenn ja, tippe [Heiltrank] oder [Fluchtseil]" +
                "\n ansonsten, tippe [nein]");

        String input = scan.nextLine();
        while (!(input.equals("Heiltrank")) && !(input.equals("Fluchtseil")) && !(input.equals("nein"))) {
            System.out.println("Falsche Eingabe, bitte erneut eintippen");
            input = scan.nextLine();
        }

        switch (input) {
            case "Heiltrank":
                if (Inventory.size() == 0)
                    System.out.println("Dein Inventar ist leer!");
                else if (checkHealthPotion()) {
                    System.out.println("Du setzt einen Heiltrank ein");
                    player.getConsumableFromInventory("Heiltrank").consume();
                } else {
                    System.out.println("Du hast keinen Heiltrank!");
                }

                break;


            case "Fluchtseil":
                if (Inventory.size() == 0)
                    System.out.println("Dein Inventar ist leer!");
                else if (checkEscRope()) {
                    System.out.println("Du setzt ein Fluchtseil ein!");
                    skip();
                    player.getConsumableFromInventory("Fluchtseil").consume();
                } else {
                    System.out.println("Du hast kein Fluchtseil!");

                }

                break;
            case "nein":
                return;
        }

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

