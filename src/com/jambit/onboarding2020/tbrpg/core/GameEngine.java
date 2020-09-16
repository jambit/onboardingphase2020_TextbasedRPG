package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameEngine {

   private ArrayList<AbstractRoom> rooms;

   public GameEngine(ArrayList<AbstractRoom> rooms){
      this.rooms = rooms;
   }

   public void run() throws IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      while (line.equalsIgnoreCase("quit") == false) {
         for (AbstractRoom room : rooms) {
            //Ask user for interaction
            System.out.println("Du stest vor folgendem Raum: " + room.getClass() + " Willst du eintreten?");
            line = in.readLine();
            if(line.equalsIgnoreCase("enter")){
               room.enter();
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
