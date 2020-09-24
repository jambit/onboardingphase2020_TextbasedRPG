package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;

public abstract class AbstractRoom {

   public void printRoomMessage() {
      System.out.println("Als nächstes musst du in den XY Raum");
   }

   public void printWelcomeMessage() {
      System.out.println("Du stehst vor Raum XY. Hier kannst du dies und das machen. Möchtest du eintreten?");
   }

   public void enter() throws PlayerDeadException {

      System.out.println("Du bist im eingetreten. Mach dich bereit...");
   }

   public void skip() {
      System.out.println("Feigling...du überspringst den Raum.");
   }
}
