package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.Hallway;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private final ArrayList<AbstractRoom> rooms;

   public GameEngine(ArrayList<AbstractRoom> rooms) {
      this.rooms = rooms;
   }

   public void run() throws IOException {

      GameInput in = new GameInput(new InputStreamReader(System.in));
      System.out.println("Du kannst 'enter' und 'quit' tippen.");

      while (in.gameState()) {

         Hallway hallway = new Hallway();

         for (AbstractRoom room : rooms) {
            room.printWelcomeMessage();

            try {
               if (in.inputRoomdecision()) {
                  room.enter();
                  hallway.enter();
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
