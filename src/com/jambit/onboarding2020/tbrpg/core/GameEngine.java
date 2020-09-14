package com.jambit.onboarding2020.tbrpg.core;

<<<<<<< HEAD
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
=======
import com.jambit.onboarding2020.tbrpg.domain.Player;
>>>>>>> 990c8c582886d1b35902cd98b906fdb8f3f32bbf
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private ArrayList<AbstractRoom> rooms;

   private Player player;

   public GameEngine(ArrayList<AbstractRoom> rooms, Player player){
      this.rooms = rooms;
      this.player = player;
   }

   public void run() throws IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      while (line.equalsIgnoreCase("quit") == false) {
         for (AbstractRoom room : rooms) {
            room.printWelcomeMessage();

            //Ask user for interaction
            line = in.readLine();
            if(line.equalsIgnoreCase("enter")){
               room.enter(this.player);
               //Remove room from list after entered
            }
            else if(line.equalsIgnoreCase("skip")){
               room.skip();
            }
            else{
               System.out.println("Deine Eingabe war nicht gültig. Du kannst 'enter', 'skip' und 'quit' tippen.");
            }
         }
      }
      System.out.println("Spiel beendet.");
      in.close();
   }

}
