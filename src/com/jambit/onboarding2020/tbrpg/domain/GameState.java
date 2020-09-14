package com.jambit.onboarding2020.tbrpg.domain;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

import java.util.ArrayList;

/**
 * This class contains all states of the game e.g. health, level ups, items etc...
 */
public class GameState {

   private int healthState;
   private String gamerName;
   private ArrayList<Item> itemList;

   public GameState(){
      itemList = new ArrayList<>(); //maybe add here typical starting items

   }

   public int getHealthState() {
      return healthState;
   }

   public void setHealthState(int healthState) {
      this.healthState = healthState;
   }

   public String getGamerName() {
      return gamerName;
   }

   public void setGamerName(String gamerName) {
      this.gamerName = gamerName;
   }
}
