package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.ExampleRoom;
import java.util.ArrayList;

public class RoomGenerator {

   public ArrayList<AbstractRoom> generateRooms(){
      ArrayList<AbstractRoom> rooms = new ArrayList<>();

      rooms.add(new ExampleRoom());
      //add more rooms to your list here and randomize
      return rooms;
   }

}
