package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.InputStreamReader;
import java.util.Random;

public class MobRoom extends AbstractRoom {

   @Override
   public void printWelcomeMessage() {
      System.out.println("Du stehst vor Raum '" + this.getClass().getSimpleName() + "'. Hier kannst du dies und das machen. Möchtest du eintreten?");
   }

   @Override
   public void enter() {

      GameInput in = new GameInput(new InputStreamReader(System.in));
      Enemy enemy = new Enemy(); // Name übergeben von Enemy
      Random random = new Random();

      System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
      System.out.println("Attack Damage Player: " + Player.getPlayerInstance().getHealthState());
      System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

      while (in.gameState()) {
         System.out.println("Drücke 1) um anzugreifen oder 2) um zu verteidigen.");

         try {
            fight(in, enemy, random);
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }

         evaluateFight(in, enemy);
      }
   }

   private void fight(GameInput in, Enemy enemy, Random random) throws Exception {
      int input = in.inputInteger();

      if (input == 1) {
         if (random.nextBoolean()) {
            Player.getPlayerInstance().attack(enemy);
            System.out.println("Treffer!");
         } else {
            System.out.println("Der Gegner hat den Angriff abgewehrt");
         }
      }

      if (random.nextBoolean()) {
         if (input == 2) {
            System.out.println("Du hast den Angriff des Gegner abgewehrt!");
         } else {
            enemy.attack(Player.getPlayerInstance());
            System.out.println("Du wurdest getroffen!");
         }
      }
   }

   private void evaluateFight(GameInput in, Enemy enemy) {
      System.out.println("Attack Damage Player: " + Player.getPlayerInstance().getHealthState());
      System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

      if (Player.getPlayerInstance().getHealthState() == 0) {
         in.looseGame();
      }

      if (enemy.getHealthState() == 0) {
         in.winGame();
      }
   }

   @Override
   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
