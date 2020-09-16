package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MobRoom extends AbstractRoom {

   @Override
   public void printWelcomeMessage() {
      System.out.println("Du stehst vor Raum '" + this.getClass().getSimpleName() + "'. Hier kannst du dies und das machen. Möchtest du eintreten?");
   }

   @Override
   public void enter(Player player) {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";
      Enemy enemy = new Enemy(); // Name übergeben von Enemy
      Random random = new Random();

      System.out.println("Attack Damage Player: " + player.getHealthState());
      System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

      while (line.equalsIgnoreCase("quit") == false) {
         System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
         System.out.println("Drücke 1) um anzugreifen oder 2) um zu verteidigen.");

         if (line.equals("1")) {
            if (random.nextBoolean()) {
               player.attack(enemy);
               System.out.println("Treffer!");
            } else {
               System.out.println("Der Gegner hat den Angriff abgewehrt");
            }
         }

         if (random.nextBoolean() && !line.equals("enter")) {
            if (line.equals("2")) {
               System.out.println("Du hast den Angriff des Gegner abgewehrt!");
            } else if(line.equals("1")) {
               enemy.attack(player);
               System.out.println("Du wurdest getroffen!");
            }
         }

         System.out.println("Attack Damage Player: " + player.getHealthState());
         System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

         if (player.getHealthState() == 0) {
            System.out.println("Du hast leider verloren!");
            return;
         }

         if (enemy.getHealthState() == 0) {
            System.out.println("Sieg! Du kommst nun in den Merchant Room und kannst dir was aussuchen!");
            return;
         }

         try {
            line = in.readLine();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
