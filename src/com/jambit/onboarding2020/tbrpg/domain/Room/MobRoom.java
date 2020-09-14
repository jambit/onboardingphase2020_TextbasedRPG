package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

      while (line.equalsIgnoreCase("quit") == false) {
         System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
         //Implement your custom room logic here

         // Angriff - Sinn dahinter
         System.out.println("Attack Damage Player: " + player.getHealthState());
         System.out.println("Attack Damage Enemy: " + enemy.getHealthState());
         player.attack(enemy);
         enemy.attack(player);
         System.out.println("Attack Damage Player: " + player.getHealthState());
         System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

         // Wenn Gegner HP 0 oder eigene HP 0 dann Spiel beendet
         // --
         //
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
