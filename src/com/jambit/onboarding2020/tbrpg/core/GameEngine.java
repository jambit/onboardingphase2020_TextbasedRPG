package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

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

      GameInput in = new GameInput(new InputStreamReader(System.in));
      System.out.println("Du kannst 'enter' und 'quit' tippen.");

      while (in.gameState()) {
         for (AbstractRoom room : rooms) {
            room.printWelcomeMessage();

            //Ask user for interaction
            try {
               if (in.inputRoomdecision()) {
                  room.enter(this.player);
                  //Remove room from list after entered
               } else {
                  break;
               }
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
         }
      }
      in.close();
   }

}
