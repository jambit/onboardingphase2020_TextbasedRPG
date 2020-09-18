package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.BossRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.Hallway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private final ArrayList<AbstractRoom> rooms;

   public GameEngine(ArrayList<AbstractRoom> rooms) {
      this.rooms = rooms;
   }

   public void run() throws IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";
      BossRoom bossRoom = new BossRoom();

//      while (line.equalsIgnoreCase("quit") == false) {

      Hallway hallway = new Hallway();

      for (AbstractRoom room : rooms) {
         room.enter();
         hallway.enter();
      }
//      }

      bossRoom.enter();

      System.out.println("Spiel beendet.");
      in.close();
   }
}
