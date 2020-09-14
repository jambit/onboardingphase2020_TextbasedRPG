package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.ExampleRoom;
<<<<<<< HEAD
import com.jambit.onboarding2020.tbrpg.domain.Room.MerchantRoom;
=======
>>>>>>> 990c8c582886d1b35902cd98b906fdb8f3f32bbf
import com.jambit.onboarding2020.tbrpg.domain.Room.MobRoom;

import java.util.ArrayList;
import java.util.Random;

public class RoomGenerator {

    //Attribute
    int roomCountPreset = 4;   //Noch anzupassen!!!
    Random random = new Random();
    ArrayList<AbstractRoom> possibleRooms = new ArrayList<>();

    //Konstruktor
    public RoomGenerator() {
        possibleRooms.add(new MerchantRoom());
    }

    //Methoden
    public ArrayList<AbstractRoom> generateRooms() {
        ArrayList<AbstractRoom> rooms = new ArrayList<>();

        for (int i = 0; i < roomCount(roomCountPreset); i++) {

            //Choose a Random Index from the possibleRooms list
            int index = random.nextInt(possibleRooms.size());

            //add the room from the possibleRooms list to the list, we want to return
            rooms.add(possibleRooms.get(index));

            //remove the room from the possibleRooms list, to avoid repetition
            if (roomCountPreset < possibleRooms.size()) {
                possibleRooms.remove(index);
            }
        }

        return rooms;
    }

<<<<<<< HEAD
    //returns a number between minCount and minCount+3
    // with different probabilities
    private int roomCount(int minCount) {
        return random.nextInt(3) + minCount;
    }
=======
      rooms.add(new MobRoom());
      //add more rooms to your list here and randomize
      return rooms;
   }
>>>>>>> 990c8c582886d1b35902cd98b906fdb8f3f32bbf

}
