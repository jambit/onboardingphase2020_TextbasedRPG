package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

import com.jambit.onboarding2020.tbrpg.domain.Room.BossRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.StoryRoom;
import com.jambit.onboarding2020.tbrpg.utils.Output;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {

   private final ArrayList<AbstractRoom> rooms;
   private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   public Scanner input = new Scanner(System.in);

   public GameEngine(ArrayList<AbstractRoom> rooms) {
      this.rooms = rooms;
   }

   public void run() throws IOException, InterruptedException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      startStory();

      for (AbstractRoom room : rooms) {
         

         System.out.println();
         System.out.println("*************************************************************" +
                            "\n            Ein neuer Raum wartet auf dich..." +
                            "\n*************************************************************");
         System.out.println();
         room.printRoomMessage();

         System.out.println("Wenn du willst, kannst du vorher dein Inventar verwalten? Tippe: " +
                 "\n ja [j] nein [n]");
         line = this.getPlayerInput();
         if (line.equalsIgnoreCase("ja") || line.equalsIgnoreCase("j")) {
            this.interactWithInventory();
         }

         room.printWelcomeMessage();

         if (!GameState.getGameStateInstance().escapeRopeActive) {
            GameState.getGameStateInstance().escapeRopeActive = false;

            try {
               room.enter();
            } catch (PlayerDeadException | InterruptedException | FileNotFoundException e) {
               System.out.println(e.getMessage());
               break;
            }
         }
      }


      System.out.println("Glückwunsch! Du hast das Spiel gewonnen. Jetzt kannst du wieder auf deinen Heimatplaneten zurück,\n" +
              "auf dem ein solches Chaos unvorstellbar ist!");
      String firework = "        .\n" +
              "      .' |\t\n" +
              "    .'   |\t \n" +
              "    /`-._'\t  \n" +
              "   /   /\t\n" +
              "  /   /\n" +
              " /   /  z\n" +
              "(`-./\t z\n" +
              " )\t\t  z\n" +
              "'\t\t   zzzzzz";
      Output.slow(firework);
      System.out.println("\n" +
              "              *    *\n" +
              "   *         '       *       .  *   '     .           * *\n" +
              "                                                               '\n" +
              "       *                *'          *          *        '\n" +
              "   .           *               |               /\n" +
              "               '.         |    |      '       |   '     *\n" +
              "                 \\*        \\   \\             /\n" +
              "       '          \\     '* |    |  *        |*                *  *\n" +
              "            *      `.       \\   |     *     /    *      '\n" +
              "  .                  \\      |   \\          /               *\n" +
              "     *'  *     '      \\      \\   '.       |\n" +
              "        -._            `                  /         *\n" +
              "  ' '      ``._   *                           '          .      '\n" +
              "   *           *\\*          * .   .      *\n" +
              "*  '        *    `-._                       .         _..:='        *\n" +
              "             .  '      *       *    *   .       _.:--'\n" +
              "          *           .     .     *         .-'         *\n" +
              "   .               '             . '   *           *         .\n" +
              "  *       ___.-=--..-._     *                '               '\n" +
              "                                  *       *\n" +
              "                *        _.'  .'       `.        '  *             *\n" +
              "     *              *_.-'   .'            `.               *\n" +
              "                   .'                       `._             *  '\n" +
              "   '       '                        .       .  `.     .\n" +
              "       .                      *                  `\n" +
              "               *        '             '                          .\n" +
              "     .                          *        .           *  *\n" +
              "             *        .                                    '");
      rollCredits();
      in.close();
   }

   private void rollCredits(){
      Output.slow("::::::CREDITS::::::");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tStefan");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tEva");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tCarina");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tChristoph");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tLukas");
      Output.slow("-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-");
      Output.slow("\t\tSteffi");

      Output.slow("::::::SPECIAL THANKS::::::");
      Output.slow("\t\tCherry");
      Output.slow("\t\tDie Zweitjahr-Azubis");
      Output.slow("\t\tCherry");
      Output.slow("\t\tHannah F.");
      Output.slow("\t\tCherry");


   }

   private void startStory() {
      StoryRoom storyRoom = new StoryRoom();
      storyRoom.printWelcomeMessage();
      storyRoom.enter();
   }

   public void interactWithInventory() {

      Player player = Player.getPlayerInstance();


      System.out.println("Du ruhst dich im Gang zwischen den Räumen kurz aus...");

      System.out.println("Was möchtest du in der Zwischenzeit tun?" +
              "\nHeiltrank [h]\t\t\t\tFluchtseil [f]" +
              "\nstatte Waffe aus [s]\t\tlege Waffe ab [l] " +
              "\nüberprüfe Inventar [ü]");

      System.out.println("\nOder willst du den Raum direkt betreten? Tippe:" +
              "\neintreten [e]");

      String line = input.nextLine();

      while (!line.equalsIgnoreCase("e")) {

         if (line.equalsIgnoreCase("Heiltrank") || line.equalsIgnoreCase("h")) {
            if (player.getConsumableFromInventory("Heiltrank") != null) {
               player.getConsumableFromInventory("Heiltrank").consume();
            } else {
               System.out.println("Du hast keinen Heiltrank im Inventar!");
            }

         } else if (line.equalsIgnoreCase("Fluchtseil") || line.equalsIgnoreCase("f")) {
            if (player.getConsumableFromInventory("Fluchtseil") != null) {
               player.getConsumableFromInventory("Fluchtseil").consume();
            } else {
               System.out.println("Du hast keine Fluchtseil im Inventar!");
            }

         } else if (line.equalsIgnoreCase("statte Waffe aus") || line.equalsIgnoreCase("s")) {
            if (!player.isWeaponInventoryEmpty()) {
               System.out.println("Du hast im Moment keine Waffen im Inventar. Tippe: " +
                       "\nHeiltrank [h] \t\t\t\tFluchtseil [f]" +
                       "\nstatte Waffe aus [s] \t\tlege Waffe ab [l] " +
                       "\nüberprüfe Inventar [ü]" +
                       "\noder" +
                       "\neintreten[e]");
            } else {
               System.out.println("Aktuell hast du folgende Waffen im Inventar:");
               player.printWeaponsFromInventory();
               System.out.println("Wähle eine Waffe, um diese auszustatten.");
               int index;
               try {
                  index = Integer.parseInt(in.readLine());
               } catch (Exception e) {
                  index = 0;
                  System.out.println("Ungültiger Zahlenwert für Waffe, wähle einen gültigen Index.");
               }
               if (index < player.getWeaponsFromInventory().size() && index != 0) {
                  player.equipWeapon(player.getWeaponsFromInventory().get(index - 1));
               }
            }
         } else if (line.equalsIgnoreCase("lege Waffe ab") || line.equalsIgnoreCase("l")) {
            player.unequipWeapon();
         } else if (line.equalsIgnoreCase("überprüfe Inventar") || line.equalsIgnoreCase("ü")) {
            player.printInventory();
            System.out.println("SpaceDollar: " + player.getBalance());
         } else {
            System.out.println("Ungültige Eingabe. Tippe: " +
                    "\nHeiltrank [h] Fluchtseil [f]" +
                    "\nstatte Waffe aus [s] lege Waffe ab [l] " +
                    "\nüberprüfe Inventar [ü]" +
                    "\noder" +
                    "\neintreten[e]");
         }

         System.out.println("Was möchtest du in der Zwischenzeit tun?");

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
