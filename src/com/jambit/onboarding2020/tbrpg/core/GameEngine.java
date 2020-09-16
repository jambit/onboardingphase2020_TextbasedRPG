package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.Hallway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private final ArrayList<AbstractRoom> rooms;
   private final Player player;

   public GameEngine(ArrayList<AbstractRoom> rooms, Player player) {
      this.rooms = rooms;
      this.player = player;
   }

   public void run() throws IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      while (line.equalsIgnoreCase("quit") == false) {

         Hallway hallway = new Hallway();

         for (AbstractRoom room : rooms) {
            room.enter(this.player);
            hallway.enter(this.player);
         }
      }
      System.out.println("Spiel beendet.");
      in.close();
   }

}
