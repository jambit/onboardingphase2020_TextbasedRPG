package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private final ArrayList<AbstractRoom> rooms;
   private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   private final GameState gameState = new GameState();

   public GameEngine(ArrayList<AbstractRoom> rooms) {
      this.rooms = rooms;
   }

   public void run() throws IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      for (AbstractRoom room : rooms) {
         room.printWelcomeMessage();

         System.out.println("Willst du dein Inventar verwalten? (tippe: <nutze Inventar>)");
         line = this.getPlayerInput();
         if (line.equalsIgnoreCase("nutze Inventar")) {
            this.interactWithInventory();
         }

         if (!gameState.escapeRopeActive) {
            gameState.escapeRopeActive = false;

            try {
               room.enter();
            } catch (PlayerDeadException | FileNotFoundException e) {
               System.out.println(e.getMessage());
               break;
            }
         }
      }


      System.out.println("Spiel beendet.");
      in.close();
   }

   public void interactWithInventory() {

      Player player = Player.getPlayerInstance();
      String line = "";

      System.out.println("Nicht schlecht, du hast den Raum geschafft\n " +
              "Du ruhst dich im Gang zwischen den Räumen kurz aus");

      while (!line.equalsIgnoreCase("enter")) {

         if (line.equalsIgnoreCase("verwende Heiltrank")) {
            if (player.getConsumableFromInventory("Heiltrank") != null) {
               player.getConsumableFromInventory("Heiltrank").consume();
            } else {
               System.out.println("Du hast keinen Heiltrank im Inventar!");
            }

         } else if (line.equalsIgnoreCase("verwende Fluchttrick")) {
            if (player.getConsumableFromInventory("Fluchttrick") != null) {
               player.getConsumableFromInventory("Fluchttrick").consume();
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
         } else if (line.equalsIgnoreCase("überprüfe Inventar")) {
            player.printInventory();
            System.out.println("Dein Gold: " + player.getBalance());
         } else {
            System.out.println("Ungültige Eingabe. \nMögliche Handlungen: \"verwende Heiltrank\", \"verwende Fluchttrick\", " +
                    "\n\"statte Waffe aus\", \"lege Waffe ab\", \"überprüfe Inventar\"");
         }

         System.out.println("Was möchtest du in der zwischenzeit tun?");

         try {
            line = in.readLine();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   public String getPlayerInput() {
      try {
         return in.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }

}
