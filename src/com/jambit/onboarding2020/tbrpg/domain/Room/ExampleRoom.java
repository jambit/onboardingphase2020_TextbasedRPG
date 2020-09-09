package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleRoom extends AbstractRoom {

   @Override
   public void printWelcomeMessage() {
      System.out.println("Du stehst vor Raum '" + this.getClass().getSimpleName() + "'. Hier kannst du dies und das machen. Möchtest du eintreten?");
   }

   @Override
   public void enter() {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line = "";

      while (line.equalsIgnoreCase("quit") == false) {
         System.out.println("Du bist gefangen und kommst nur raus, wenn du den Schlüssel findest, oder 'quit' drückst");
         //Implement your custom room logic here
         try {
            line = in.readLine();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
