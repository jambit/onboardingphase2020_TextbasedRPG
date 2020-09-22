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
import java.util.Random;
import java.util.Scanner;

public class MobRoom extends AbstractRoom {

   Player player = Player.getPlayerInstance();
   Scanner scan = new Scanner(System.in);

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

      System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
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
      System.out.println("Lebenspunkte des Players: " + Player.getPlayerInstance().getHealthState());
      System.out.println("Lebenspunkte des Enemy: " + enemy.getHealthState());
      chooseItem(player);
   }

   private void chooseItem(Player player) {
      System.out.println("Möchstest du ein Item einsetzen? " +
              "\n Wenn ja, tippe [Health Potion] oder [Escape Rope]" +
              "\n ansonsten, tippe [nein]");

      String input = scan.nextLine();
         while(!(input == "Health Potion" || input == "Escape Rope" || input == "nein")){
            System.out.println("Falsche Eingabe, bitte erneut eintippen");
            input = scan.nextLine();
         }
            if(input == "Health Potion") {

         System.out.println("Du setzt einen Heiltrank ein");
         player.getConsumableFromInventory("Heiltrank").consume();

      }else if (input == "Escape Rope"){
         player.takeItemFromInventory("EscapeRope");
         skip();
      }
      else if (input == "nein"){
         return;
      }

   }


   @Override
   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
