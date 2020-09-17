package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hallway extends AbstractRoom {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void enter(Player player) {

        String line = "";

        System.out.println("Nicht schlecht, du hast den Raum geschafft\n " +
                "Du ruhst dich im Gang zwischen den Räumen kurz aus");

        while (!line.equalsIgnoreCase("quit")) {

            if (line.equalsIgnoreCase("verwende Heiltrank")) {
                if (player.getConsumableFromInventory("Heiltrank") != null) {
                    player.getConsumableFromInventory("Heiltrank").consume(player);
                } else {
                    System.out.println("Du hast keinen Heiltrank im Inventar!");
                }

            } else if (line.equalsIgnoreCase("verwende Fluchttrick")) {
                if (player.getConsumableFromInventory("Fluchttrick") != null) {
                    player.getConsumableFromInventory("Fluchttrick").consume(player);
                }

            } else if (line.equalsIgnoreCase("statte Waffe aus")) {
                System.out.println("Aktuell hast du folgende Waffen im Inventar:");
                player.printWeaponsFromInventory();
                System.out.println("Wähle eine Waffe, um diese auszustatten");
                int index;
                try {
                    index = Integer.parseInt(in.readLine());
                } catch (Exception e) {
                    index = 0;
                    System.out.println("Ungültiger Zahlenwert für Waffe, wähle einen Gültigen Index");
                }
                if (index < player.getWeaponsFromInventory().size() && index != 0) {
                    player.equipWeapon(player.getWeaponsFromInventory().get(index - 1));
                }
            } else if (line.equalsIgnoreCase("lege Waffe ab")) {
                player.unequipWeapon();
            } else {
                System.out.println("Ungültige Eingabe. \nMögliche Handlungen: \"verwende Heiltrank\", \"verwende Fluchttrick\", " +
                        "\n\"statte Waffe aus\", \"lege Waffe ab\"");
            }

            System.out.println("Was möchtest du in der zwischenzeit tun?");

            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
