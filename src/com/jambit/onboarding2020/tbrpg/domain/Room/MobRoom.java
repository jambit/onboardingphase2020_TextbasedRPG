package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.core.InvalidInputException;
import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.EnemyDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;

import java.io.InputStreamReader;
import java.util.Random;

public class MobRoom extends AbstractRoom {

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

      System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
      System.out.println("Attack Damage Player: " + Player.getPlayerInstance().getHealthState());
      System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

      while (in.isGameRunning()) {
         System.out.println("Drücke 1) um anzugreifen oder 2) um zu verteidigen.");

         try {
            fight(in, enemy, random);
         } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
         }

         evaluateFight(in, enemy);
      }
   }

   private void fight(GameInput in, Enemy enemy, Random random) throws InvalidInputException, PlayerDeadException {
      int input = in.inputInteger();
      ItemGenerator itemGenerator = new ItemGenerator();

      if (input == 1) {
         if (random.nextBoolean()) {
            try {
               Player.getPlayerInstance().attack(enemy);
            } catch (EnemyDeadException e) {
               System.out.println(e.getMessage());
               in.endGame();
               itemGenerator.interactWithRoomLoot();
               return;
            }
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
      System.out.println("Lebenspunkte des Players: " + Player.getPlayerInstance().getHealthState());
      System.out.println("Lebenspunkte des Enemy: " + enemy.getHealthState());
   }

   @Override
   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
